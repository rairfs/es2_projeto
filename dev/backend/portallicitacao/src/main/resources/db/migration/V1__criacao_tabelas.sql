-- MySQL Script generated by MySQL Workbench
-- Mon Mar 11 09:58:25 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Estado` (
  `sigla` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`sigla`),
  UNIQUE INDEX `sigla_UNIQUE` (`sigla` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Municipio` (
  `nome` VARCHAR(150) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `regiao` VARCHAR(45) NOT NULL,
  `codigoIBGE` VARCHAR(45) NOT NULL,
  `nomeIBGE` VARCHAR(45) NOT NULL,
  `codigoRegiao` VARCHAR(45) NOT NULL,
  `nomeRegiao` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `Estado_sigla` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`codigoIBGE`),
  INDEX `fk_Municipio_Estado1_idx` (`Estado_sigla` ASC) VISIBLE,
  UNIQUE INDEX `codigoIBGE_UNIQUE` (`codigoIBGE` ASC) VISIBLE,
  CONSTRAINT `fk_Municipio_Estado1`
    FOREIGN KEY (`Estado_sigla`)
    REFERENCES `mydb`.`Estado` (`sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Modalidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Modalidade` (
  `codigo` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrgaoVinculado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OrgaoVinculado` (
  `codigoSIAFI` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigoSIAFI`),
  UNIQUE INDEX `codigoSIAFI_UNIQUE` (`codigoSIAFI` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OrgaoMaximo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OrgaoMaximo` (
  `codigo` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UnidadeGestora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`UnidadeGestora` (
  `codigo` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricaoPoder` VARCHAR(45) NOT NULL,
  `OrgaoVinculado_codigoSIAFI` VARCHAR(45) NOT NULL,
  `OrgaoMaximo_codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_UnidadeGestora_OrgaoVinculado1_idx` (`OrgaoVinculado_codigoSIAFI` ASC) VISIBLE,
  INDEX `fk_UnidadeGestora_OrgaoMaximo1_idx` (`OrgaoMaximo_codigo` ASC) VISIBLE,
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  CONSTRAINT `fk_UnidadeGestora_OrgaoVinculado1`
    FOREIGN KEY (`OrgaoVinculado_codigoSIAFI`)
    REFERENCES `mydb`.`OrgaoVinculado` (`codigoSIAFI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UnidadeGestora_OrgaoMaximo1`
    FOREIGN KEY (`OrgaoMaximo_codigo`)
    REFERENCES `mydb`.`OrgaoMaximo` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Licitacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Licitacao` (
  `idLicitacao` INT NOT NULL,
  `situacai` VARCHAR(45) NOT NULL,
  `dataResultadoCompra` DATETIME NOT NULL,
  `dataAbertura` DATETIME NOT NULL,
  `dataPublicacao` DATETIME NOT NULL,
  `situacaoCompra` VARCHAR(45) NOT NULL,
  `instrumentoLegal` VARCHAR(45) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `Municipio_codigoIBGE` VARCHAR(45) NOT NULL,
  `Modalidade_codigo` VARCHAR(50) NOT NULL,
  `UnidadeGestora_codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLicitacao`),
  INDEX `fk_Licitacao_Municipio1_idx` (`Municipio_codigoIBGE` ASC) VISIBLE,
  INDEX `fk_Licitacao_Modalidade1_idx` (`Modalidade_codigo` ASC) VISIBLE,
  INDEX `fk_Licitacao_UnidadeGestora1_idx` (`UnidadeGestora_codigo` ASC) VISIBLE,
  UNIQUE INDEX `idLicitacao_UNIQUE` (`idLicitacao` ASC) VISIBLE,
  CONSTRAINT `fk_Licitacao_Municipio1`
    FOREIGN KEY (`Municipio_codigoIBGE`)
    REFERENCES `mydb`.`Municipio` (`codigoIBGE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Licitacao_Modalidade1`
    FOREIGN KEY (`Modalidade_codigo`)
    REFERENCES `mydb`.`Modalidade` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Licitacao_UnidadeGestora1`
    FOREIGN KEY (`UnidadeGestora_codigo`)
    REFERENCES `mydb`.`UnidadeGestora` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fornecedor` (
  `nome` VARCHAR(150) NOT NULL,
  `razaoSocial` VARCHAR(45) NOT NULL,
  `cpfCnpj` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpfCnpj`),
  UNIQUE INDEX `cpfCnpj_UNIQUE` (`cpfCnpj` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ItemLicitacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ItemLicitacao` (
  `codigoItemCompra` VARCHAR(50) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(150) NOT NULL,
  `valorUnitario` DOUBLE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valorTotal` DOUBLE NOT NULL,
  `cpfCnpjVencendor` VARCHAR(45) NOT NULL,
  `tipoPessoa` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descUnidadeFornecimento` VARCHAR(45) NOT NULL,
  `descComplementarItemCompra` VARCHAR(45) NOT NULL,
  `Fornecedor_cpfCnpj` VARCHAR(45) NOT NULL,
  `Licitacao_idLicitacao` INT NOT NULL,
  PRIMARY KEY (`codigoItemCompra`),
  INDEX `fk_ItemLicitacao_Fornecedor1_idx` (`Fornecedor_cpfCnpj` ASC) VISIBLE,
  UNIQUE INDEX `codigoItemCompra_UNIQUE` (`codigoItemCompra` ASC) VISIBLE,
  INDEX `fk_ItemLicitacao_Licitacao1_idx` (`Licitacao_idLicitacao` ASC) VISIBLE,
  CONSTRAINT `fk_ItemLicitacao_Fornecedor1`
    FOREIGN KEY (`Fornecedor_cpfCnpj`)
    REFERENCES `mydb`.`Fornecedor` (`cpfCnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItemLicitacao_Licitacao1`
    FOREIGN KEY (`Licitacao_idLicitacao`)
    REFERENCES `mydb`.`Licitacao` (`idLicitacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Compra` (
  `numero` VARCHAR(45) NOT NULL,
  `objeto` VARCHAR(45) NOT NULL,
  `numeroProcesso` VARCHAR(45) NOT NULL,
  `contatoResponsavel` VARCHAR(45) NOT NULL,
  `Licitacao_idLicitacao` INT NOT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC) VISIBLE,
  INDEX `fk_Compra_Licitacao1_idx` (`Licitacao_idLicitacao` ASC) VISIBLE,
  CONSTRAINT `fk_Compra_Licitacao1`
    FOREIGN KEY (`Licitacao_idLicitacao`)
    REFERENCES `mydb`.`Licitacao` (`idLicitacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Participante` (
  `idParticipante` VARCHAR(45) NOT NULL,
  `tipoParticipante` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `RazaoSocial` VARCHAR(45) NOT NULL,
  `cpfCnpj` VARCHAR(45) NOT NULL,
  `Participantecol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idParticipante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Empenho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Empenho` (
  `empenho` VARCHAR(45) NOT NULL,
  `empenhoResumido` VARCHAR(45) NOT NULL,
  `dataEmissao` DATE NOT NULL,
  `observacao` VARCHAR(45) NULL,
  `valor` VARCHAR(45) NOT NULL,
  `Licitacao_idLicitacao` INT NOT NULL,
  PRIMARY KEY (`empenho`),
  INDEX `fk_Empenho_Licitacao1_idx` (`Licitacao_idLicitacao` ASC) VISIBLE,
  CONSTRAINT `fk_Empenho_Licitacao1`
    FOREIGN KEY (`Licitacao_idLicitacao`)
    REFERENCES `mydb`.`Licitacao` (`idLicitacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Participante_Licitacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Participante_Licitacao` (
  `Participante_idParticipante` VARCHAR(45) NOT NULL,
  `Licitacao_idLicitacao` INT NOT NULL,
  `idParticipante_Licitacao` VARCHAR(45) NOT NULL,
  INDEX `fk_Participante_has_Licitacao_Licitacao1_idx` (`Licitacao_idLicitacao` ASC) VISIBLE,
  INDEX `fk_Participante_has_Licitacao_Participante1_idx` (`Participante_idParticipante` ASC) VISIBLE,
  PRIMARY KEY (`idParticipante_Licitacao`),
  CONSTRAINT `fk_Participante_has_Licitacao_Participante1`
    FOREIGN KEY (`Participante_idParticipante`)
    REFERENCES `mydb`.`Participante` (`idParticipante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Participante_has_Licitacao_Licitacao1`
    FOREIGN KEY (`Licitacao_idLicitacao`)
    REFERENCES `mydb`.`Licitacao` (`idLicitacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

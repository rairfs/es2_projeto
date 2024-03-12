USE `mydb` ;

ALTER TABLE `mydb`.`Licitacao`
  DROP `situacai`;

ALTER TABLE `mydb`.`Licitacao`
  ADD `situacao` VARCHAR(45) NOT NULL;


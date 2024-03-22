INSERT INTO `mydb`.`orgaomaximo` (`codigo`,`sigla`,`nome`) VALUES ('1','OMT','Orgao Maximo Teste');
INSERT INTO `mydb`.`orgaovinculado` (`codigoSIAFI`,`cnpj`,`sigla`,`nome`) VALUES ('1', '1111111111111111','OVT','ORGAO VINCULADO TESTE');
INSERT INTO `mydb`.`unidadegestora`(`codigo`,`nome`,`descricaoPoder`,`OrgaoVinculado_codigoSIAFI`,`OrgaoMaximo_codigo`) VALUES ('1','UNIDADE GESTORA TESTE','DESCRICAO PODER TESTE','1','1');
INSERT INTO `mydb`.`estado` (`sigla`,`nome`) VALUES ('SE','SERGIPE');
INSERT INTO `mydb`.`municipio`(`nome`,`estado`,`regiao`,`codigoIBGE`,`nomeIBGE`,`codigoRegiao`,`nomeRegiao`,`pais`,`Estado_sigla`)
VALUES
('ARACAJU','SERGIPE','NORDESTE','1','ARACAJU','1','NORDESTE','BRASIL','SE');

INSERT INTO `mydb`.`modalidade` (`codigo`,`descricao`) VALUES ('1','PREGÃO');
INSERT INTO `mydb`.`licitacao`
(`idLicitacao`,`dataResultadoCompra`,`dataAbertura`,`dataPublicacao`,`situacaoCompra`,`instrumentoLegal`,`valor`,`Municipio_codigoIBGE`,
`Modalidade_codigo`,`UnidadeGestora_codigo`,`situacao`)
VALUES
(1,'2024-03-13','2024-03-13','2024-03-13','A','TESTE',1000.00,'1','1','1','A');
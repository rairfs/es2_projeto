package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Orgao {

    @Id
    private String codigo;
    private String codigoSIAFI;
    private String sigla;
    private String nome;
    private String cnpj;

}

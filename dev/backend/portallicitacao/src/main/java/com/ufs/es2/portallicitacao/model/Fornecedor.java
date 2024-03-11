package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Fornecedor {

    @Id
    private String cpfCnpj;
    private String nome;
    private String razaoSocial;
    private String tipoPessoa;

}

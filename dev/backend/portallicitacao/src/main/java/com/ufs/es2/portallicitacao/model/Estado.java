package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estado {

    @Id
    private String sigla;
    private String nome;

}

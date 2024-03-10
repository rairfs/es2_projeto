package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Modalidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;
    private String descricao;

}

package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Compra {

    @Id
    private String numero;
    private String objeto;
    private String numeroProcesso;
    private String contatoResponsavel;
    @OneToOne
    @JoinColumn(name = "licitacao_id")
    private Licitacao licitacao;

}

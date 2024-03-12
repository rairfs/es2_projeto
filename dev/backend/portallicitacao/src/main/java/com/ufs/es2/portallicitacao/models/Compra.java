package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Compra {

    @Id
    @Column(nullable = false, length = 45)
    private String numero;
    @Column(nullable = false, length = 45)
    private String objeto;
    @Column(nullable = false, length = 45)
    private String numeroProcesso;
    @Column(nullable = false, length = 45)
    private String contatoResponsavel;
    @OneToOne
    @JoinColumn(name = "licitacao_idLicitacao")
    private Licitacao licitacao;

}

package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Municipio {

    @Id
    @Column(nullable = false, length = 45)
    private String codigoIBGE;
    @Column(length = 150, nullable = false)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "Estado_sigla", nullable = false)
    private Estado estado;
    @Column(nullable = false, length = 45)
    private String regiao;
    @Column(nullable = false, length = 45)
    private String nomeIBGE;
    @Column(nullable = false, length = 45)
    private String codigoRegiao;
    @Column(nullable = false, length = 45)
    private String nomeRegiao;
    @Column(nullable = false, length = 45)
    private String pais;

}

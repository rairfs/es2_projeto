package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empenho {

    @Id
    @Column(nullable = false, length = 45)
    private String empenho;
    @Column(nullable = false, length = 45)
    private String empenhoResumido;
    @Column(nullable = false)
    private LocalDateTime dataEmissao;
    @Column(nullable = false)
    private String observacao;
    @Column(nullable = false)
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name = "licitacao_idLicitacao")
    private Licitacao licitacao;

}

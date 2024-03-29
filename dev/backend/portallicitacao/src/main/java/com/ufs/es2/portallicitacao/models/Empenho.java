package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

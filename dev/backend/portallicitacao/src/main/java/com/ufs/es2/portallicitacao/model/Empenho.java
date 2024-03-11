package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Empenho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String empenhoResumido;
    private LocalDateTime dataEmissao;
    private String observacao;
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name = "licitacao_id")
    private Licitacao licitacao;

}

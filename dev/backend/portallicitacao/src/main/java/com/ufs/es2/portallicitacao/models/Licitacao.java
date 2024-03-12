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
public class Licitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLicitacao;
    @Column(nullable = false, length = 45)
    private String situacao;
    @Column(nullable = false)
    private LocalDateTime dataResultadoCompra;
    @Column(nullable = false)
    private LocalDateTime dataAbertura;
    @Column(nullable = false)
    private LocalDateTime dataPublicacao;
    @Column(nullable = false, length = 45)
    private String situacaoCompra;
    @Column(nullable = false, length = 45)
    private String instrumentoLegal;
    @Column(nullable = false)
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name = "municipio_codigoIBGE")
    private Municipio municipio;
    @ManyToOne
    @JoinColumn(name = "modalidade_codigo")
    private Modalidade modalidade;
    @ManyToOne
    @JoinColumn(name = "unidade_gestora_codigo")
    private UnidadeGestora unidadeGestora;

}

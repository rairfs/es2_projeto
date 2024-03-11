package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Licitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String situacao;
    private LocalDateTime dataResultadoCompra;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataPublicacao;
    private String situacaoCompra;
    private String instrumentoLegal;
    private BigDecimal valor;
    @ManyToOne
    @JoinColumn(name = "municipio_codigo")
    private String municipioCodigoIBGE;
    @ManyToOne
    @JoinColumn(name = "modalidade_codigo")
    private String modalidadeCodigo;
    @ManyToOne
    @JoinColumn(name = "unidade_gestora_codigo")
    private String unidadeGestora;

}

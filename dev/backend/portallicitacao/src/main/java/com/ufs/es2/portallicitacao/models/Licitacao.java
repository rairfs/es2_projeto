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
    @JoinColumn(name = "Municipio_codigoIBGE")
    private Municipio municipio;
    @ManyToOne
    @JoinColumn(name = "Modalidade_codigo")
    private Modalidade modalidade;
    @ManyToOne
    @JoinColumn(name = "UnidadeGestora_codigo")
    private UnidadeGestora unidadeGestora;

    public static class Builder {
        private Integer idLicitacao;
        private BigDecimal valor;
        private String situacao;
        private String situacaoCompra;

        public Builder idLicitacao(Integer idLicitacao){
            this.idLicitacao = idLicitacao;
            return this;
        }

        public Builder valor(BigDecimal valor){
            this.valor = valor;
            return this;
        }

        public Builder situacao(String situacao){
            this.situacao = situacao;
            return this;
        }

        public Builder situacaoCompra(String situacaoCompra){
            this.situacaoCompra = situacaoCompra;
            return this;
        }

        public Licitacao build(){
            Licitacao licitacao = new Licitacao();
            licitacao.idLicitacao = idLicitacao;
            licitacao.valor = valor;
            licitacao.situacao = situacao;
            licitacao.situacaoCompra = situacaoCompra;
            return licitacao;
        }

    }

}

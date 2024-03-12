package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemLicitacao {

    @Id
    @Column(nullable = false, length = 50)
    private String codigoItemCompra;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, length = 150)
    private String descricao;
    @Column(nullable = false)
    private BigDecimal valorUnitario;
    @Column(nullable = false)
    private BigDecimal quantidade;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    @Column(nullable = false, length = 45)
    private String cpfCnpjVencedor;
    @Column(nullable = false, length = 45)
    private String descUnidadeFornecimento;
    @Column(nullable = false, length = 45)
    private String descComplementarItemCompra;
    @Column(nullable = false, length = 45)
    private String tipoPessoa;
    @ManyToOne
    @JoinColumn(name = "fornecedor_cpfCnpj")
    private Fornecedor fornecedor;
    @ManyToOne
    @JoinColumn(name = "licitacao_idLicitacao")
    private Licitacao licitacao;

}

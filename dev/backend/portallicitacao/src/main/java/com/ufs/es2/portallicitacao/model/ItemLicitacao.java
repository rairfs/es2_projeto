package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class ItemLicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigoItemCompra;
    private String nome;
    private String descricao;
    private BigDecimal valorUnitario;
    private BigDecimal quantidade;
    private BigDecimal valorTotal;
    private String cpfCnpjVencedor;
    private String descUnidadeFornecimento;
    private String descComplementarItemCompra;
    @ManyToOne
    @JoinColumn(name = "fornecedor_cpfCnpj")
    private Fornecedor fornecedor;
    @ManyToOne
    @JoinColumn(name = "licitacao_id")
    private Licitacao licitacao;

}

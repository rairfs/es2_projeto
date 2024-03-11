package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class UnidadeGestora {

    @Id
    private String codigo;
    private String nome;
    private String descricaoPoder;
    @ManyToOne
    @JoinColumn(name = "orgao_vinculado_codigo")
    private Orgao orgaoVinculado;
    @ManyToOne
    @JoinColumn(name = "orgao_maximo_codigo")
    private Orgao orgaoMaximo;

}

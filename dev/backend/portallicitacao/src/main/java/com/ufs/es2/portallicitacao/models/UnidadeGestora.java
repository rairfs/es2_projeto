package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UnidadeGestora {

    @Id
    @Column(nullable = false, length = 45)
    private String codigo;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, length = 45)
    private String descricaoPoder;
    @ManyToOne
    @JoinColumn(name = "orgao_vinculado_codigo")
    private OrgaoVinculado orgaoVinculado;
    @ManyToOne
    @JoinColumn(name = "orgao_maximo_codigo")
    private OrgaoMaximo orgaoMaximo;

}

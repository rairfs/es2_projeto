package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadeGestora {

    @Id
    @Column(nullable = false, length = 45)
    private String codigo;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, length = 45)
    private String descricaoPoder;
    @ManyToOne
    @JoinColumn(name = "OrgaoVinculado_codigoSIAFI")
    private OrgaoVinculado orgaoVinculado;
    @ManyToOne
    @JoinColumn(name = "OrgaoMaximo_codigo")
    private OrgaoMaximo orgaoMaximo;

}

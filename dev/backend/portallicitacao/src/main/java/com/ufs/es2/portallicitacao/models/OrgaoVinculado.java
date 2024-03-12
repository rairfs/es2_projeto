package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrgaoVinculado {

    @Id
    @Column(nullable = false, length = 45)
    private String codigoSIAFI;
    @Column(nullable = false, length = 45)
    private String cnpj;
    @Column(nullable = false, length = 45)
    private String sigla;
    @Column(nullable = false, length = 45)
    private String nome;

}

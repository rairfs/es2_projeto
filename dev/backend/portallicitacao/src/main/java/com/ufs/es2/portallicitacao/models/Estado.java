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
public class Estado {

    @Id
    @Column(length = 2, nullable = false)
    private String sigla;
    @Column(length = 50, nullable = false)
    private String nome;

}

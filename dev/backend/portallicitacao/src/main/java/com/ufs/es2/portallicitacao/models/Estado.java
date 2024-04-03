package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estado {

    @Id
    @Column(length = 2, nullable = false)
    private String sigla;
    @Column(length = 50, nullable = false)
    private String nome;

}

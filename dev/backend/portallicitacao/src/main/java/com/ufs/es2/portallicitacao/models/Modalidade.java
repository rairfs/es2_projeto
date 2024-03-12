package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Modalidade {

    @Id
    @Column(nullable = false, length = 50)
    private String codigo;
    @Column(nullable = false, length = 45)
    private String descricao;

}

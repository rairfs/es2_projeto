package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Modalidade {

    @Id
    @Column(nullable = false, length = 50)
    private String codigo;
    @Column(nullable = false, length = 45)
    private String descricao;

}

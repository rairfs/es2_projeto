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
public class Participante {

    @Id
    @Column(nullable = false, length = 45)
    private Integer idParticipante;
    @Column(nullable = false, length = 45)
    private String tipoParticipante;
    @Column(nullable = false, length = 45)
    private String nome;
    @Column(nullable = false, length = 45)
    private String razaoSocial;
    @Column(nullable = false, length = 45)
    private String cpfCnpj;

}

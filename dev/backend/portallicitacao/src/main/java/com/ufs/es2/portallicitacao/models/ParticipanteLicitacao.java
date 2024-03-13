package com.ufs.es2.portallicitacao.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "participante_licitacao")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParticipanteLicitacao {

    @Id
    @Column(name = "idParticipante_Licitacao")
    private String idParticipanteLicitacao;
    @ManyToOne
    @JoinColumn(name = "participante_idParticipante")
    private Participante participante;
    @ManyToOne
    @JoinColumn(name = "licitacao_idLicitacao")
    private Licitacao licitacao;

}

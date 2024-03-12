package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "participante_licitacao")
@Getter
@Setter
@NoArgsConstructor
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

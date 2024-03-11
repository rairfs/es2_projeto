package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "participante_licitacao")
@Data
public class ParticipanteLicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParticipanteLicitacao;
    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;
    @ManyToOne
    @JoinColumn(name = "licitacao_id")
    private Licitacao licitacao;

}

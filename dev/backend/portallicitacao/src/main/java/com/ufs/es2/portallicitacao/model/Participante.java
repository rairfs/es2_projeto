package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParticipante;
    private String tipoParticipante;
    private String nome;
    private String razaoSocial;
    private String cpfCnpj;
    private String participanteCol;

}

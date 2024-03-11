package com.ufs.es2.portallicitacao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Municipio {

    @Id
    private String codigoIBGE;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "estado_sigla")
    private Estado estado;
    private String regiao;
    private String nomeIBGE;
    private String codigoRegiao;
    private String nomeRegiao;
    private String pais;

}

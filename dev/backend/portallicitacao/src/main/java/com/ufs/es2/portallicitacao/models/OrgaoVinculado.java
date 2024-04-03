package com.ufs.es2.portallicitacao.models;

import com.ufs.es2.portallicitacao.models.adapters.OrgaoAdapter;
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
public class OrgaoVinculado implements OrgaoAdapter {

    @Id
    @Column(nullable = false, length = 45)
    private String codigoSIAFI;
    @Column(nullable = false, length = 45)
    private String cnpj;
    @Column(nullable = false, length = 45)
    private String sigla;
    @Column(nullable = false, length = 45)
    private String nome;

    @Override
    public String getCodigo() {
        return this.codigoSIAFI;
    }

    @Override
    public String getSigla() {
        return this.sigla;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

}

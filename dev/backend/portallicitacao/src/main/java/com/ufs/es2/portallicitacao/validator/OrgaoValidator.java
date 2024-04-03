package com.ufs.es2.portallicitacao.validator;

import com.ufs.es2.portallicitacao.models.adapters.OrgaoAdapter;

import java.util.Objects;

public class OrgaoValidator {

    public static void validarOrgao(OrgaoAdapter orgaoAdapter){
        if (Objects.isNull(orgaoAdapter.getSigla()) || orgaoAdapter.getSigla().isBlank()){
            throw new RuntimeException("A sigla do órgão precisa ser informado");
        }
        if (Objects.isNull(orgaoAdapter.getNome()) || orgaoAdapter.getNome().isBlank()){
            throw new RuntimeException("O nome do órgão precisa ser informado");
        }
    }

}

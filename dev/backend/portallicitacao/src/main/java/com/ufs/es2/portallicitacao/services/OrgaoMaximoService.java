package com.ufs.es2.portallicitacao.services;

import com.ufs.es2.portallicitacao.models.OrgaoMaximo;
import com.ufs.es2.portallicitacao.repositories.OrgaoMaximoRepository;
import com.ufs.es2.portallicitacao.validator.OrgaoValidator;

import java.util.Optional;

public class OrgaoMaximoService {

    private OrgaoMaximoRepository orgaoMaximoRepository;

    public OrgaoMaximoService(OrgaoMaximoRepository orgaoMaximoRepository){
        this.orgaoMaximoRepository = orgaoMaximoRepository;
    }

    public void save(OrgaoMaximo orgaoMaximo){
        if(orgaoMaximo == null) throw new RuntimeException("Ocorreu uma falha ao receber os dados do Órgão.");
        OrgaoValidator.validarOrgao(orgaoMaximo);
        Optional<OrgaoMaximo> orgaoMaximoEncontrado = orgaoMaximoRepository.findById(orgaoMaximo.getCodigo());
        if(orgaoMaximoEncontrado.isEmpty()){
            orgaoMaximoRepository.save(orgaoMaximo);
        }
    }

}

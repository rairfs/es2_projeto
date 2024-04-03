package com.ufs.es2.portallicitacao.services;

import com.ufs.es2.portallicitacao.models.OrgaoVinculado;
import com.ufs.es2.portallicitacao.repositories.OrgaoVinculadoRepository;
import com.ufs.es2.portallicitacao.validator.OrgaoValidator;

import java.util.Optional;

public class OrgaoVinculadoService {

    private OrgaoVinculadoRepository orgaoVinculadoRepository;

    public OrgaoVinculadoService(OrgaoVinculadoRepository orgaoVinculadoRepository){
        this.orgaoVinculadoRepository = orgaoVinculadoRepository;
    }

    public void save(OrgaoVinculado orgaoVinculado){
        if(orgaoVinculado == null) throw new RuntimeException("Ocorreu uma falha ao receber os dados do Órgão.");
        OrgaoValidator.validarOrgao(orgaoVinculado);
        Optional<OrgaoVinculado> orgaoVinculadoEncontrado = orgaoVinculadoRepository.findById(orgaoVinculado.getCodigo());
        if(orgaoVinculadoEncontrado.isEmpty()){
            orgaoVinculadoRepository.save(orgaoVinculado);
        }
    }

}

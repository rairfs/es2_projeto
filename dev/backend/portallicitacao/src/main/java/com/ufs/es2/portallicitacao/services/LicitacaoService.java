package com.ufs.es2.portallicitacao.services;

import com.ufs.es2.portallicitacao.models.Licitacao;
import com.ufs.es2.portallicitacao.repositories.LicitacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicitacaoService {

    private LicitacaoRepository licitacaoRepository;

    public LicitacaoService(LicitacaoRepository licitacaoRepository){
        this.licitacaoRepository = licitacaoRepository;
    }

    public List<Licitacao> getAll(){
        return this.licitacaoRepository.findAll();
    }

    public Licitacao findById(Integer id){
        return this.licitacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Licitação não encontrada para este ID."));
    }

}

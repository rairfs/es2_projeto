package com.ufs.es2.portallicitacao.services;

import com.ufs.es2.portallicitacao.models.Modalidade;
import com.ufs.es2.portallicitacao.repositories.ModalidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidadeService {

    private final ModalidadeRepository modalidadeRepository;

    public ModalidadeService(ModalidadeRepository unidadeGestoraRepository){
        this.modalidadeRepository = unidadeGestoraRepository;
    }

    public List<Modalidade> getAll(){
        return this.modalidadeRepository.findAll();
    }

    public Modalidade findById(String id){
        return this.modalidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modalidade não encontrada para este ID."));
    }

}

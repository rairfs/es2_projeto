package com.ufs.es2.portallicitacao.services;

import com.ufs.es2.portallicitacao.models.Modalidade;
import com.ufs.es2.portallicitacao.models.UnidadeGestora;
import com.ufs.es2.portallicitacao.repositories.UnidadeGestoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeGestoraService {

    private final UnidadeGestoraRepository unidadeGestoraRepository;

    public UnidadeGestoraService(UnidadeGestoraRepository unidadeGestoraRepository){
        this.unidadeGestoraRepository = unidadeGestoraRepository;
    }

    public List<UnidadeGestora> getAll(){
        return this.unidadeGestoraRepository.findAll();
    }

    public UnidadeGestora findById(String id){
        return this.unidadeGestoraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unidade Gestora não encontrada para este ID."));
    }

    public void save(UnidadeGestora unidadeGestora){
        if(unidadeGestora == null) throw new RuntimeException();
        Optional<UnidadeGestora> unidadeGestoraEncontrada = unidadeGestoraRepository.findById(unidadeGestora.getCodigo());
        if(unidadeGestoraEncontrada.isEmpty()){
            unidadeGestoraRepository.save(unidadeGestora);
        }
    }

}

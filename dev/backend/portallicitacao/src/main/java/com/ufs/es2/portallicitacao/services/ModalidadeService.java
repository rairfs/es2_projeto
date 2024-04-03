package com.ufs.es2.portallicitacao.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ufs.es2.portallicitacao.models.Modalidade;
import com.ufs.es2.portallicitacao.repositories.ModalidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalidadeService {

    private final ModalidadeRepository modalidadeRepository;

    public ModalidadeService(ModalidadeRepository unidadeGestoraRepository){
        this.modalidadeRepository = unidadeGestoraRepository;
    }

    public Page<Modalidade> getAll(Pageable pageable){
        return this.modalidadeRepository.findAll(pageable);
    }

    public Modalidade findById(String id){
        return this.modalidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modalidade não encontrada para este ID."));
    }

    public void save(Modalidade modalidade){
        if(modalidade == null) throw new RuntimeException();
        Optional<Modalidade> modalidadeEncontrada = modalidadeRepository.findById(modalidade.getCodigo());
        if(modalidadeEncontrada.isEmpty()){
            modalidadeRepository.save(modalidade);
        }
    }


}

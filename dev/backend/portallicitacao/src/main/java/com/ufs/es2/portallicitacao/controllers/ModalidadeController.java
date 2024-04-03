package com.ufs.es2.portallicitacao.controllers;

import com.ufs.es2.portallicitacao.models.Modalidade;
import com.ufs.es2.portallicitacao.services.ModalidadeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/modalidades")
public class ModalidadeController {

    private final ModalidadeService modalidadeService;

    public ModalidadeController(ModalidadeService modalidadeService){
        this.modalidadeService = modalidadeService;
    }

    @GetMapping
    public ResponseEntity<Page<Modalidade>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Modalidade> modalidades = modalidadeService.getAll(pageable);
        return ResponseEntity.ok().body(modalidades);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Modalidade> findById(@PathVariable(value = "id") String id){
        Modalidade modalidade = modalidadeService.findById(id);
        return ResponseEntity.ok().body(modalidade);
    }

}

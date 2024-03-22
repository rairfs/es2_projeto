package com.ufs.es2.portallicitacao.controllers;

import com.ufs.es2.portallicitacao.models.UnidadeGestora;
import com.ufs.es2.portallicitacao.services.UnidadeGestoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/unidadesGestoras")
public class UnidadeGestoraController {

    private final UnidadeGestoraService unidadeGestoraService;

    public UnidadeGestoraController(UnidadeGestoraService unidadeGestoraService){
        this.unidadeGestoraService = unidadeGestoraService;
    }

    @GetMapping
    public ResponseEntity<List<UnidadeGestora>> getAll(){
        List<UnidadeGestora> unidadesGestoras = unidadeGestoraService.getAll();
        return ResponseEntity.ok().body(unidadesGestoras);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeGestora> findById(@PathVariable(value = "id") String id){
        UnidadeGestora unidadeGestora = unidadeGestoraService.findById(id);
        return ResponseEntity.ok().body(unidadeGestora);
    }

}

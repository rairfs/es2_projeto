package com.ufs.es2.portallicitacao.controllers;

import com.ufs.es2.portallicitacao.models.Licitacao;
import com.ufs.es2.portallicitacao.services.LicitacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/licitacoes/")
public class LicitacaoController {

    private LicitacaoService licitacaoService;

    public LicitacaoController(LicitacaoService licitacaoService){
        this.licitacaoService = licitacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Licitacao>> getAll(){
        List<Licitacao> licitacaos = licitacaoService.getAll();
        return ResponseEntity.ok().body(licitacaos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Licitacao> findById(@PathVariable(value = "id") Integer id){
        Licitacao licitacao = licitacaoService.findById(id);
        return ResponseEntity.ok().body(licitacao);
    }

}

package com.ufs.es2.portallicitacao.controllers;

import com.ufs.es2.portallicitacao.models.Licitacao;
import com.ufs.es2.portallicitacao.models.UnidadeGestora;
import com.ufs.es2.portallicitacao.services.LicitacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licitacoes")
public class LicitacaoController {

    private final LicitacaoService licitacaoService;

    public LicitacaoController(LicitacaoService licitacaoService) {
        this.licitacaoService = licitacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Licitacao>> getAll() {
        List<Licitacao> licitacaos = licitacaoService.getAll();
        return ResponseEntity.ok().body(licitacaos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Licitacao> findById(@PathVariable(value = "id") Integer id) {
        Licitacao licitacao = licitacaoService.findById(id);
        return ResponseEntity.ok().body(licitacao);
    }

    @GetMapping("/findByModalidade")
    public ResponseEntity<List<Licitacao>> getAllByFilter(@RequestParam(value = "codigoModalidade") String codigoModalidade) {
        List<Licitacao> licitacaos = licitacaoService.findAllByModalidade_codigo(codigoModalidade);
        return ResponseEntity.ok().body(licitacaos);
    }

}

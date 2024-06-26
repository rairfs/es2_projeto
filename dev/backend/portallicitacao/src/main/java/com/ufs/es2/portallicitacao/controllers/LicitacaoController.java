package com.ufs.es2.portallicitacao.controllers;

import com.ufs.es2.portallicitacao.models.Licitacao;
import com.ufs.es2.portallicitacao.models.UnidadeGestora;
import com.ufs.es2.portallicitacao.services.LicitacaoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/licitacoes")
public class LicitacaoController {

    private final LicitacaoService licitacaoService;

    public LicitacaoController(LicitacaoService licitacaoService) {
        this.licitacaoService = licitacaoService;
    }

    // @GetMapping
    // public ResponseEntity<List<Licitacao>> getAll() {
    //     List<Licitacao> licitacaos = licitacaoService.getAll();
    //     return ResponseEntity.ok().body(licitacaos);
    // }

    @GetMapping
    public ResponseEntity<Page<Licitacao>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "valor") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Pageable pageable = PageRequest.of(page, size,
                Sort.by(sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy));;
        Page<Licitacao> licitacoes = licitacaoService.getAll(pageable);
        
        return ResponseEntity.ok().body(licitacoes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Licitacao> findById(@PathVariable(value = "id") Integer id) {
        Licitacao licitacao = licitacaoService.findById(id);
        return ResponseEntity.ok().body(licitacao);
    }

    @GetMapping("/findByModalidade/{codigoModalidade}")
    public ResponseEntity<List<Licitacao>> getAllByModalidade(@PathVariable(value = "codigoModalidade") String codigoModalidade) {
        List<Licitacao> licitacaos = licitacaoService.findAllByModalidade(codigoModalidade);
        return ResponseEntity.ok().body(licitacaos);
    }

    @GetMapping("/findByUnidadeGestora/{codigoUnidadeGestora}")
    public ResponseEntity<List<Licitacao>> getAllByUnidadeGestora(@PathVariable(value = "codigoUnidadeGestora") String codigoUnidadeGestora) {
        List<Licitacao> licitacaos = licitacaoService.findAllByUnidadeGestora(codigoUnidadeGestora);
        return ResponseEntity.ok().body(licitacaos);
    }

    @PostMapping("/sincronizaLicitacoes")
    public ResponseEntity<String> uploadXls(@RequestParam("file") MultipartFile file) {
        try  {
            licitacaoService.inserirLicitacoes(file);
            return ResponseEntity.ok().body("Arquivo .xls processado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao processar arquivo.");
        }
    }


}

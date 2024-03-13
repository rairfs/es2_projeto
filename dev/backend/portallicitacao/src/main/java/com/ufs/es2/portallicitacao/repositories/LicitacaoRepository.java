package com.ufs.es2.portallicitacao.repositories;

import com.ufs.es2.portallicitacao.models.Licitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LicitacaoRepository extends JpaRepository<Licitacao, Integer> {
}

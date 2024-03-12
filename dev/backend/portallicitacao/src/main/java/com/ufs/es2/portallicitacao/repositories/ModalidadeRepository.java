package com.ufs.es2.portallicitacao.repositories;

import com.ufs.es2.portallicitacao.models.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, String> {
}

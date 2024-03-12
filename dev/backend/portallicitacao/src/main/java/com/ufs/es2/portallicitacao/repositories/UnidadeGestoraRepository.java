package com.ufs.es2.portallicitacao.repositories;

import com.ufs.es2.portallicitacao.models.UnidadeGestora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeGestoraRepository extends JpaRepository<UnidadeGestora, String> {
}

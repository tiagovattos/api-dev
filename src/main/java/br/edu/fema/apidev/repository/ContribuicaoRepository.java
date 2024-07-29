package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Contribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContribuicaoRepository extends JpaRepository<Contribuicao, Long> {
    Optional<Contribuicao> findByAplicativoIdAndDesenvolvedorId(Long idApp, Long idDev);
}

package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Contribuicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContribuicaoRepository extends JpaRepository<Contribuicao, Long> {
}

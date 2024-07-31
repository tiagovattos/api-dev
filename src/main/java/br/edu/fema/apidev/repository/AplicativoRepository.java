package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Aplicativo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
    Optional<Aplicativo> findFirstBy(Sort sort);
}

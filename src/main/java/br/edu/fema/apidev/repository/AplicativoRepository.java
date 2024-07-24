package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Aplicativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {
}

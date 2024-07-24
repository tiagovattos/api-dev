package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
}

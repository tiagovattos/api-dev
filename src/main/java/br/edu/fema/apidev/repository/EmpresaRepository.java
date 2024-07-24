package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}

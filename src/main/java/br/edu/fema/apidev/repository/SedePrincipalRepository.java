package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.SedePrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedePrincipalRepository extends JpaRepository<SedePrincipal, Long> {
}

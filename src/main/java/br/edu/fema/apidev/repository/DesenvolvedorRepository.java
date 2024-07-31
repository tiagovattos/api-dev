package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Desenvolvedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
    Optional<Desenvolvedor> findByNome(String nome);
    Optional<Desenvolvedor> findFirstByOrderByDataNascimento();
}

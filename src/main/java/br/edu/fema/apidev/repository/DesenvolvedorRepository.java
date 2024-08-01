package br.edu.fema.apidev.repository;

import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, Long> {
    Optional<Desenvolvedor> findByNome(String nome);

    Optional<Desenvolvedor> findFirstByOrderByDataNascimento();

    List<Desenvolvedor> findByEmpresaOrderByDataNascimentoDesc(Empresa empresa);

    List<Desenvolvedor> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    void deleteByNome(String nome);

    List<Desenvolvedor> findBySalarioLessThan(BigDecimal salario);

    List<Desenvolvedor> findBySalarioLessThanEqual(BigDecimal salario);

    List<Desenvolvedor> findBySalarioGreaterThan(BigDecimal salario);

    List<Desenvolvedor> findBySalarioGreaterThanEqual(BigDecimal salario);
}

package br.edu.fema.apidev.service;

import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.dto.request.DesenvolvedorReq;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface DesenvolvedorService {
    Desenvolvedor findById(Long id);

    List<Desenvolvedor> findAll();

    Desenvolvedor save(DesenvolvedorReq desenvolvedorReq);

    Desenvolvedor update(Long id, DesenvolvedorReq desenvolvedorReq);

    void deleteById(Long id);

    Desenvolvedor findByNome(String nome);

    Desenvolvedor findMaisVelho();

    List<Desenvolvedor> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    void deleteByNome(String nome);

    List<Desenvolvedor> findBySalarioLessThan(BigDecimal salario);

    List<Desenvolvedor> findBySalarioLessThanEqual(BigDecimal salario);

    List<Desenvolvedor> findBySalarioGreaterThan(BigDecimal salario);

    List<Desenvolvedor> findBySalarioGreaterThanEqual(BigDecimal salario);
}

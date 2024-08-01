package br.edu.fema.apidev.service.impl;

import br.edu.fema.apidev.exception.ResourceNotFoundException;
import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.dto.mapper.DesenvolvedorMapper;
import br.edu.fema.apidev.model.dto.request.DesenvolvedorReq;
import br.edu.fema.apidev.repository.DesenvolvedorRepository;
import br.edu.fema.apidev.service.DesenvolvedorService;
import br.edu.fema.apidev.service.EmpresaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DesenvolvedorServiceImpl implements DesenvolvedorService {
    private final DesenvolvedorRepository desenvolvedorRepository;
    private final EmpresaService empresaService;

    public DesenvolvedorServiceImpl(DesenvolvedorRepository desenvolvedorRepository, EmpresaService empresaService) {
        this.desenvolvedorRepository = desenvolvedorRepository;
        this.empresaService = empresaService;
    }

    @Override
    public Desenvolvedor findById(Long id) {
        return desenvolvedorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Desenvolvedor de id = " + id + " não encontrado.")
        );
    }

    @Override
    public List<Desenvolvedor> findAll() {
        return desenvolvedorRepository.findAll();
    }

    @Override
    public Desenvolvedor save(DesenvolvedorReq desenvolvedorReq) {
        Desenvolvedor desenvolvedor = new Desenvolvedor();
        Empresa empresa = empresaService.findById(desenvolvedorReq.getEmpresaId());
        return desenvolvedorRepository.save(
                DesenvolvedorMapper.mapEntity(desenvolvedorReq, desenvolvedor, empresa));
    }

    @Override
    public Desenvolvedor update(Long id, DesenvolvedorReq desenvolvedorReq) {
        Desenvolvedor desenvolvedor = this.findById(id);
        Empresa empresa = empresaService.findById(desenvolvedorReq.getEmpresaId());
        return desenvolvedorRepository.save(
                DesenvolvedorMapper.mapEntity(desenvolvedorReq, desenvolvedor, empresa));
    }

    @Override
    public void deleteById(Long id) {
        Desenvolvedor desenvolvedor = this.findById(id);
        desenvolvedorRepository.delete(desenvolvedor);
    }

    @Override
    public Desenvolvedor findByNome(String nome) {
        return desenvolvedorRepository.findByNome(nome).orElseThrow(
                () -> new ResourceNotFoundException("Desenvolvedor de nome = " + nome + " não encontrado.")
        );
    }

    @Override
    public Desenvolvedor findMaisVelho() {
        return desenvolvedorRepository.findFirstByOrderByDataNascimento().orElseThrow(
                () -> new ResourceNotFoundException("Nenhum desenvolvedor encontrado.")
        );
    }

    @Override
    public List<Desenvolvedor> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal) {
        return desenvolvedorRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

    @Override
    @Transactional
    public void deleteByNome(String nome) {
        this.findByNome(nome);
        desenvolvedorRepository.deleteByNome(nome);
    }

    @Override
    public List<Desenvolvedor> findBySalarioLessThan(BigDecimal salario) {
        return desenvolvedorRepository.findBySalarioLessThan(salario);
    }

    @Override
    public List<Desenvolvedor> findBySalarioLessThanEqual(BigDecimal salario) {
        return desenvolvedorRepository.findBySalarioLessThanEqual(salario);
    }

    @Override
    public List<Desenvolvedor> findBySalarioGreaterThan(BigDecimal salario) {
        return desenvolvedorRepository.findBySalarioGreaterThan(salario);
    }

    @Override
    public List<Desenvolvedor> findBySalarioGreaterThanEqual(BigDecimal salario) {
        return desenvolvedorRepository.findBySalarioGreaterThanEqual(salario);
    }
}

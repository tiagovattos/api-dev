package br.edu.fema.apidev.service.impl;

import br.edu.fema.apidev.exception.ResourceNotFoundException;
import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.dto.mapper.EmpresaMapper;
import br.edu.fema.apidev.model.dto.request.EmpresaReq;
import br.edu.fema.apidev.repository.DesenvolvedorRepository;
import br.edu.fema.apidev.repository.EmpresaRepository;
import br.edu.fema.apidev.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final DesenvolvedorRepository desenvolvedorRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, DesenvolvedorRepository desenvolvedorRepository) {
        this.empresaRepository = empresaRepository;
        this.desenvolvedorRepository = desenvolvedorRepository;
    }

    @Override
    public Empresa findById(Long id) {
        return empresaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Empresa de id = " + id +" não encontrada.")
        );
    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    @Override
    public Empresa save(EmpresaReq empresaReq) {
        Empresa empresa = new Empresa();
        return empresaRepository.save(EmpresaMapper.mapEntity(empresaReq, empresa));
    }

    @Override
    public Empresa update(Long id, EmpresaReq empresaReq) {
        Empresa empresa = this.findById(id);
        return empresaRepository.save(EmpresaMapper.mapEntity(empresaReq, empresa));
    }

    @Override
    public void deleteById(Long id) {
        empresaRepository.delete(findById(id));
    }

    @Override
    public List<Desenvolvedor> findAllDevsById(Long id) {
        return this.findById(id).getDesenvolvedores();
    }

    @Override
    public Empresa findByIdOrNome(Long id, String nome) {
        return empresaRepository.findByIdOrNome(id, nome).orElseThrow(
                () -> new ResourceNotFoundException("Empresa de id = " + id +
                        " ou nome = " + nome + " não encontrada.")
        );
    }

    @Override
    public Map<String, Integer> findAllDevsOrderByAge(Long id) {
        Empresa empresa = this.findById(id);
        List<Desenvolvedor> devs = desenvolvedorRepository.findByEmpresaOrderByDataNascimentoDesc(empresa);
        Map<String, Integer> map = new LinkedHashMap<>();
        devs.forEach(
                d -> map.put(
                        d.getNome(),
                        Period.between(d.getDataNascimento(), LocalDate.now()).getYears()));
        return map;
    }


}

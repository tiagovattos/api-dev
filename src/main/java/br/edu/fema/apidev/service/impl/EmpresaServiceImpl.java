package br.edu.fema.apidev.service.impl;

import br.edu.fema.apidev.exception.ResourceNotFoundException;
import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.dto.mapper.EmpresaMapper;
import br.edu.fema.apidev.model.dto.request.EmpresaReq;
import br.edu.fema.apidev.repository.EmpresaRepository;
import br.edu.fema.apidev.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
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
}

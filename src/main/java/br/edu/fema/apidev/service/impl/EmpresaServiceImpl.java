package br.edu.fema.apidev.service.impl;

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
        return empresaRepository.findById(id).orElse(null);
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
}

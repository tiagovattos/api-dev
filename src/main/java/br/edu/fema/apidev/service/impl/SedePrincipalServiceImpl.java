package br.edu.fema.apidev.service.impl;

import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.SedePrincipal;
import br.edu.fema.apidev.model.dto.mapper.SedePrincipalMapper;
import br.edu.fema.apidev.model.dto.request.SedePrincipalReq;
import br.edu.fema.apidev.repository.SedePrincipalRepository;
import br.edu.fema.apidev.service.EmpresaService;
import br.edu.fema.apidev.service.SedePrincipalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedePrincipalServiceImpl implements SedePrincipalService {
    private final SedePrincipalRepository sedePrincipalRepository;
    private final EmpresaService empresaService;

    public SedePrincipalServiceImpl(SedePrincipalRepository sedePrincipalRepository, EmpresaService empresaService) {
        this.sedePrincipalRepository = sedePrincipalRepository;
        this.empresaService = empresaService;
    }

    @Override
    public SedePrincipal findById(Long id) {
        return sedePrincipalRepository.findById(id).orElse(null);
    }

    @Override
    public List<SedePrincipal> findAll() {
        return sedePrincipalRepository.findAll();
    }

    @Override
    public SedePrincipal save(SedePrincipalReq sedePrincipalReq) {
        SedePrincipal sedePrincipal = new SedePrincipal();
        Empresa empresa = empresaService.findById(sedePrincipalReq.getEmpresaId());
        return sedePrincipalRepository.save(
                SedePrincipalMapper.mapEntity(sedePrincipalReq, sedePrincipal, empresa));
    }

    @Override
    public SedePrincipal update(Long id, SedePrincipalReq sedePrincipalReq) {
        SedePrincipal sedePrincipal = this.findById(id);
        Empresa empresa = empresaService.findById(sedePrincipalReq.getEmpresaId());
        return sedePrincipalRepository.save(
                SedePrincipalMapper.mapEntity(sedePrincipalReq, sedePrincipal, empresa));
    }

    @Override
    public void deleteById(Long id) {
        SedePrincipal sedePrincipal = this.findById(id);
        sedePrincipalRepository.delete(sedePrincipal);
    }
}

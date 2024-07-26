package br.edu.fema.apidev.service.impl;

import br.edu.fema.apidev.model.Aplicativo;
import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.dto.mapper.AplicativoMapper;
import br.edu.fema.apidev.model.dto.request.AplicativoReq;
import br.edu.fema.apidev.repository.AplicativoRepository;
import br.edu.fema.apidev.service.AplicativoService;
import br.edu.fema.apidev.service.EmpresaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AplicativoServiceImpl implements AplicativoService {
    private final AplicativoRepository aplicativoRepository;
    private final EmpresaService empresaService;

    public AplicativoServiceImpl(AplicativoRepository aplicativoRepository, EmpresaService empresaService) {
        this.aplicativoRepository = aplicativoRepository;
        this.empresaService = empresaService;
    }


    @Override
    public Aplicativo findById(Long id) {
        return aplicativoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Aplicativo> findAll() {
        return aplicativoRepository.findAll();
    }

    @Override
    public Aplicativo save(AplicativoReq aplicativoReq) {
        Aplicativo aplicativo = new Aplicativo();
        Empresa empresa = empresaService.findById(aplicativoReq.getEmpresaId());
        aplicativo.setUltimaAtualizacao(LocalDateTime.now());
        return aplicativoRepository.save(AplicativoMapper.mapEntity(aplicativoReq, aplicativo, empresa));
    }

    @Override
    public Aplicativo update(Long id, AplicativoReq aplicativoReq) {
        Aplicativo aplicativo = this.findById(id);
        Empresa empresa = empresaService.findById(aplicativoReq.getEmpresaId());
        aplicativo.setUltimaAtualizacao(LocalDateTime.now());
        return aplicativoRepository.save(AplicativoMapper.mapEntity(aplicativoReq, aplicativo, empresa));
    }

    @Override
    public void deleteById(Long id) {
        Aplicativo aplicativo = this.findById(id);
        aplicativoRepository.delete(aplicativo);
    }
}

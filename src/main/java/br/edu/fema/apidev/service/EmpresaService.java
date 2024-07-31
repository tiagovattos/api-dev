package br.edu.fema.apidev.service;

import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.dto.request.EmpresaReq;

import java.util.List;

public interface EmpresaService {
    Empresa findById(Long id);
    List<Empresa> findAll();
    Empresa save(EmpresaReq empresaReq);
    Empresa update(Long id, EmpresaReq empresaReq);
    void deleteById(Long id);

    List<Desenvolvedor> findAllDevsById(Long id);
}

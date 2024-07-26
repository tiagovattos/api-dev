package br.edu.fema.apidev.service;

import br.edu.fema.apidev.model.SedePrincipal;
import br.edu.fema.apidev.model.dto.request.SedePrincipalReq;

import java.util.List;

public interface SedePrincipalService {
    SedePrincipal findById(Long id);
    List<SedePrincipal> findAll();
    SedePrincipal save(SedePrincipalReq sedePrincipalReq);
    SedePrincipal update(Long id, SedePrincipalReq sedePrincipalReq);
    void deleteById(Long id);
}

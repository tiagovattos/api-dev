package br.edu.fema.apidev.service;

import br.edu.fema.apidev.model.Aplicativo;
import br.edu.fema.apidev.model.dto.request.AplicativoReq;

import java.util.List;

public interface AplicativoService  {
    Aplicativo findById(Long id);
    List<Aplicativo> findAll();
    Aplicativo save(AplicativoReq aplicativoReq);
    Aplicativo update(Long id, AplicativoReq aplicativoReq);
    void deleteById(Long id);

    Aplicativo findMaisAtualizado();
}

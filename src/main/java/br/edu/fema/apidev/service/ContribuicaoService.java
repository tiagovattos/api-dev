package br.edu.fema.apidev.service;

import br.edu.fema.apidev.model.Contribuicao;
import br.edu.fema.apidev.model.dto.request.ContribuicaoReq;

import java.util.List;

public interface ContribuicaoService {
    Contribuicao findById(Long idApp, Long idDev);
    List<Contribuicao> findAll();
    Contribuicao save(ContribuicaoReq contribuicaoReq);
    void deleteById(Long idApp, Long idDev);
}

package br.edu.fema.apidev.service;

import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.dto.request.DesenvolvedorReq;

import java.util.List;

public interface DesenvolvedorService {
    Desenvolvedor findById(Long id);
    List<Desenvolvedor> findAll();
    Desenvolvedor save(DesenvolvedorReq desenvolvedorReq);
    Desenvolvedor update(Long id, DesenvolvedorReq desenvolvedorReq);
    void deleteById(Long id);
}

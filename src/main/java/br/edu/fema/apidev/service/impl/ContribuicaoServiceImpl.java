package br.edu.fema.apidev.service.impl;

import br.edu.fema.apidev.exception.ResourceNotFoundException;
import br.edu.fema.apidev.model.Aplicativo;
import br.edu.fema.apidev.model.Contribuicao;
import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.dto.mapper.ContribuicaoMapper;
import br.edu.fema.apidev.model.dto.request.ContribuicaoReq;
import br.edu.fema.apidev.repository.ContribuicaoRepository;
import br.edu.fema.apidev.service.AplicativoService;
import br.edu.fema.apidev.service.ContribuicaoService;
import br.edu.fema.apidev.service.DesenvolvedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContribuicaoServiceImpl implements ContribuicaoService {
    private final ContribuicaoRepository contribuicaoRepository;
    private final AplicativoService aplicativoService;
    private final DesenvolvedorService desenvolvedorService;

    public ContribuicaoServiceImpl(ContribuicaoRepository contribuicaoRepository, AplicativoService aplicativoService, DesenvolvedorService desenvolvedorService) {
        this.contribuicaoRepository = contribuicaoRepository;
        this.aplicativoService = aplicativoService;
        this.desenvolvedorService = desenvolvedorService;
    }

    @Override
    public Contribuicao findById(Long idApp, Long idDev) {
        return contribuicaoRepository.findByAplicativoIdAndDesenvolvedorId(idApp, idDev).orElseThrow(
                () -> new ResourceNotFoundException("Contribuição de id do desenvolvedor = " + idDev +
                        " e id do aplicativo = " + idDev + " não encontrada.")
        );
    }

    @Override
    public List<Contribuicao> findAll() {
        return contribuicaoRepository.findAll();
    }

    @Override
    public Contribuicao save(ContribuicaoReq contribuicaoReq) {
        Aplicativo aplicativo = aplicativoService.findById(contribuicaoReq.getAplicativoId());
        Desenvolvedor desenvolvedor = desenvolvedorService.findById(contribuicaoReq.getDesenvolvedorId());
        Contribuicao contribuicao = new Contribuicao();
        return contribuicaoRepository.save(
                ContribuicaoMapper.mapEntity(contribuicao, aplicativo, desenvolvedor));
    }

    @Override
    public void deleteById(Long idApp, Long idDev) {
        Contribuicao contribuicao = this.findById(idApp, idDev);
        contribuicaoRepository.delete(contribuicao);
    }
}

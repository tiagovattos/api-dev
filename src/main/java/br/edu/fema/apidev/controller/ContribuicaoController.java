package br.edu.fema.apidev.controller;

import br.edu.fema.apidev.model.Contribuicao;
import br.edu.fema.apidev.model.dto.mapper.ContribuicaoMapper;
import br.edu.fema.apidev.model.dto.request.ContribuicaoReq;
import br.edu.fema.apidev.model.dto.response.ContribuicaoRes;
import br.edu.fema.apidev.service.ContribuicaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contribuicao")
public class ContribuicaoController {
    private final ContribuicaoService contribuicaoService;

    public ContribuicaoController(ContribuicaoService contribuicaoService) {
        this.contribuicaoService = contribuicaoService;
    }

    @GetMapping("/{idApp}/{idDev}")
    public ResponseEntity<ContribuicaoRes> findById(@PathVariable Long idApp,
                                                    @PathVariable Long idDev){
        Contribuicao contribuicao = contribuicaoService.findById(idApp, idDev);
        return ResponseEntity.ok().body(
                ContribuicaoMapper.toDto(contribuicao.getAplicativo(), contribuicao.getDesenvolvedor()));
    }

    @GetMapping
    public ResponseEntity<List<ContribuicaoRes>> findAll(){
        return ResponseEntity.ok().body(
                contribuicaoService.findAll().stream()
                        .map(a -> ContribuicaoMapper.toDto(a.getAplicativo(), a.getDesenvolvedor()))
                        .toList());
    }

    @PostMapping
    public ResponseEntity<ContribuicaoRes> save(@RequestBody @Valid ContribuicaoReq contribuicaoReq){
        Contribuicao contribuicao = contribuicaoService.save(contribuicaoReq);
        return ResponseEntity.ok().body(
                ContribuicaoMapper.toDto(contribuicao.getAplicativo(), contribuicao.getDesenvolvedor())
        );
    }

    @DeleteMapping("/{idApp}/{idDev}")
    public ResponseEntity<Void> deleteById(@PathVariable Long idApp,
                                           @PathVariable Long idDev){
        contribuicaoService.deleteById(idApp, idDev);
        return ResponseEntity.ok().build();
    }
}

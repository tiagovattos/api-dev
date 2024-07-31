package br.edu.fema.apidev.controller;

import br.edu.fema.apidev.model.Aplicativo;
import br.edu.fema.apidev.model.dto.mapper.AplicativoMapper;
import br.edu.fema.apidev.model.dto.request.AplicativoReq;
import br.edu.fema.apidev.model.dto.response.AplicativoRes;
import br.edu.fema.apidev.service.AplicativoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/app")
public class AplicativoController {
    private final AplicativoService aplicativoService;


    public AplicativoController(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AplicativoRes> findById(@PathVariable Long id) {
        Aplicativo aplicativo = aplicativoService.findById(id);
        return ResponseEntity.ok().body(
                AplicativoMapper.toDto(aplicativo, aplicativo.getEmpresa()));
    }

    @GetMapping
    public ResponseEntity<List<AplicativoRes>> findAll(){
        return ResponseEntity.ok().body(aplicativoService.findAll().stream()
                .map(a -> AplicativoMapper.toDto(a, a.getEmpresa()))
                .toList());
    }

    @PostMapping
    public ResponseEntity<AplicativoRes> save(@RequestBody @Valid AplicativoReq aplicativoReq){
        Aplicativo aplicativo = aplicativoService.save(aplicativoReq);
        return ResponseEntity.ok().body(
                AplicativoMapper.toDto(aplicativo, aplicativo.getEmpresa()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AplicativoRes> update(@PathVariable Long id,
                                                @RequestBody @Valid AplicativoReq aplicativoReq){
        Aplicativo aplicativo = aplicativoService.update(id, aplicativoReq);
        return ResponseEntity.ok().body(
            AplicativoMapper.toDto(aplicativo, aplicativo.getEmpresa())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        aplicativoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mais-atualizado")
    public ResponseEntity<AplicativoRes> findMaisAtualizado(){
        Aplicativo aplicativo = aplicativoService.findMaisAtualizado();
        return ResponseEntity.ok().body(
                AplicativoMapper.toDto(aplicativo, aplicativo.getEmpresa())
        );
    }

}

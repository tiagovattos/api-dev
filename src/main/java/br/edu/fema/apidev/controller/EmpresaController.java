package br.edu.fema.apidev.controller;

import br.edu.fema.apidev.model.dto.mapper.DesenvolvedorMapper;
import br.edu.fema.apidev.model.dto.mapper.EmpresaMapper;
import br.edu.fema.apidev.model.dto.request.EmpresaReq;
import br.edu.fema.apidev.model.dto.response.DesenvolvedorRes;
import br.edu.fema.apidev.model.dto.response.EmpresaRes;
import br.edu.fema.apidev.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaRes> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                EmpresaMapper.toDto(empresaService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<EmpresaRes>> findAll() {
        return ResponseEntity.ok().body(
                empresaService.findAll().stream()
                        .map(EmpresaMapper::toDto)
                        .toList());
    }

    @PostMapping
    public ResponseEntity<EmpresaRes> save(@RequestBody @Valid EmpresaReq empresaReq) {
        return ResponseEntity.ok().body(
                EmpresaMapper.toDto(empresaService.save(empresaReq)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaRes> update(@PathVariable Long id, @RequestBody @Valid EmpresaReq empresaReq) {
        return ResponseEntity.ok().body(
                EmpresaMapper.toDto(empresaService.update(id, empresaReq)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        empresaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/devs")
    public ResponseEntity<List<DesenvolvedorRes>> findAllDevsById(@PathVariable Long id) {
        return ResponseEntity.ok().body(
                (empresaService.findAllDevsById(id)).stream()
                        .map(d -> DesenvolvedorMapper.toDto(d, d.getEmpresa()))
                        .toList()
        );
    }

    @GetMapping("/{id}/ou/{nome}")
    public ResponseEntity<EmpresaRes> findByIdOrNome(@PathVariable Long id, @PathVariable String nome) {
        return ResponseEntity.ok().body(
                EmpresaMapper.toDto(empresaService.findByIdOrNome(id, nome))
        );
    }
}

package br.edu.fema.apidev.controller;

import br.edu.fema.apidev.model.SedePrincipal;
import br.edu.fema.apidev.model.dto.mapper.SedePrincipalMapper;
import br.edu.fema.apidev.model.dto.request.SedePrincipalReq;
import br.edu.fema.apidev.model.dto.response.SedePrincipalRes;
import br.edu.fema.apidev.service.SedePrincipalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sedePrincipal")
public class SedePrincipalController {
    private final SedePrincipalService sedePrincipalService;

    public SedePrincipalController(SedePrincipalService sedePrincipalService) {
        this.sedePrincipalService = sedePrincipalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SedePrincipalRes> findById(@PathVariable Long id) {
        SedePrincipal sedePrincipal = sedePrincipalService.findById(id);
        return ResponseEntity.ok().body(
                SedePrincipalMapper.toDto(sedePrincipal, sedePrincipal.getEmpresa()));
    }

    @GetMapping
    public ResponseEntity<List<SedePrincipalRes>> findAll() {
        return ResponseEntity.ok().body(
                sedePrincipalService.findAll().stream()
                        .map(a -> SedePrincipalMapper.toDto(a, a.getEmpresa()))
                        .toList());
    }

    @PostMapping
    public ResponseEntity<SedePrincipalRes> save(@RequestBody SedePrincipalReq sedePrincipalReq) {
        SedePrincipal sedePrincipal = sedePrincipalService.save(sedePrincipalReq);
        return ResponseEntity.ok().body(
                SedePrincipalMapper.toDto(sedePrincipal, sedePrincipal.getEmpresa()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SedePrincipalRes> update(@PathVariable Long id,
                                                   @RequestBody SedePrincipalReq sedePrincipalReq) {
        SedePrincipal sedePrincipal = sedePrincipalService.update(id, sedePrincipalReq);
        return ResponseEntity.ok().body(
                SedePrincipalMapper.toDto(sedePrincipal, sedePrincipal.getEmpresa()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        sedePrincipalService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package br.edu.fema.apidev.controller;

import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.dto.mapper.DesenvolvedorMapper;
import br.edu.fema.apidev.model.dto.request.DesenvolvedorReq;
import br.edu.fema.apidev.model.dto.response.DesenvolvedorRes;
import br.edu.fema.apidev.service.DesenvolvedorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/dev")
public class DesenvolvedorController {
    private final DesenvolvedorService desenvolvedorService;

    public DesenvolvedorController(DesenvolvedorService desenvolvedorService) {
        this.desenvolvedorService = desenvolvedorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesenvolvedorRes> findById(@PathVariable Long id) {
        Desenvolvedor desenvolvedor = desenvolvedorService.findById(id);
        return ResponseEntity.ok().body(
                DesenvolvedorMapper.toDto(desenvolvedor, desenvolvedor.getEmpresa()));
    }

    @GetMapping
    public ResponseEntity<List<DesenvolvedorRes>> findAll() {
        return ResponseEntity.ok().body(
                desenvolvedorService.findAll().stream()
                        .map(a -> DesenvolvedorMapper.toDto(a, a.getEmpresa()))
                        .toList());
    }

    @PostMapping
    public ResponseEntity<DesenvolvedorRes> save(@RequestBody @Valid DesenvolvedorReq desenvolvedorReq) {
        Desenvolvedor desenvolvedor = desenvolvedorService.save(desenvolvedorReq);
        return ResponseEntity.ok().body(
                DesenvolvedorMapper.toDto(
                        desenvolvedor, desenvolvedor.getEmpresa()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesenvolvedorRes> update(@PathVariable Long id,
                                                   @RequestBody @Valid DesenvolvedorReq desenvolvedorReq){
        Desenvolvedor desenvolvedor = desenvolvedorService.update(id, desenvolvedorReq);
        return ResponseEntity.ok().body(
                DesenvolvedorMapper.toDto(
                        desenvolvedor, desenvolvedor.getEmpresa()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        desenvolvedorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<DesenvolvedorRes> findByNome(@RequestParam String nome) {
        Desenvolvedor desenvolvedor = desenvolvedorService.findByNome(nome);
        return ResponseEntity.ok().body(
                DesenvolvedorMapper.toDto(desenvolvedor, desenvolvedor.getEmpresa()));
    }

    @GetMapping("/mais-velho")
    public ResponseEntity<DesenvolvedorRes> findMaisVelho(){
        Desenvolvedor desenvolvedor = desenvolvedorService.findMaisVelho();
        return ResponseEntity.ok().body(
                DesenvolvedorMapper.toDto(desenvolvedor, desenvolvedor.getEmpresa())
        );
    }

    @GetMapping("/data-entre")
    public ResponseEntity<List<DesenvolvedorRes>> findByDataNascimentoBetween(@RequestParam LocalDate dataInicial,
                                                                              @RequestParam LocalDate dataFinal){
        List<Desenvolvedor> desenvolvedores = desenvolvedorService.findByDataNascimentoBetween(dataInicial, dataFinal);
        return ResponseEntity.ok().body(
                desenvolvedores.stream()
                        .map(a -> DesenvolvedorMapper.toDto(a, a.getEmpresa()))
                        .toList()
        );
    }

    @DeleteMapping("/nome/{nome}")
    public ResponseEntity<Void> deleteByNome(@PathVariable String nome){
        desenvolvedorService.deleteByNome(nome);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/salario</{salario}")
    public ResponseEntity<List<DesenvolvedorRes>> findBySalarioLessThan(@PathVariable BigDecimal salario){
        return ResponseEntity.ok().body(
                desenvolvedorService.findBySalarioLessThan(salario).stream()
                        .map(a -> DesenvolvedorMapper.toDto(a, a.getEmpresa()))
                        .toList()
        );
    }
}

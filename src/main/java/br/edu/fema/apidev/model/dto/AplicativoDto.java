package br.edu.fema.apidev.model.dto;

import br.edu.fema.apidev.model.Contribuicao;
import br.edu.fema.apidev.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoDto {
    private Long id;
    private String nome;
    private Empresa empresa;
    private Set<Contribuicao> contribuicoes;
    private LocalDateTime ultimaAtualizacao;
}

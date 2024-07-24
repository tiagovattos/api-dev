package br.edu.fema.apidev.model.dto;

import br.edu.fema.apidev.model.Contribuicao;
import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.enums.Contrato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesenvolvedorDto {
    private Long id;
    private String nome;
    private Empresa empresa;
    private Set<Contribuicao> contribuicoes;
    private LocalDate dataNascimento;
    private Contrato contrato;
    private BigDecimal salario;
}

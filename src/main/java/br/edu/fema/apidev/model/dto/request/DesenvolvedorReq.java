package br.edu.fema.apidev.model.dto.request;

import br.edu.fema.apidev.model.enums.Contrato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DesenvolvedorReq {
    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo empresa id é obrigatório.")
    private Long empresaId;

    @NotNull(message = "O campo data de nascimento é obrigatório.")
    private LocalDate dataNascimento;
    private Contrato contrato;
    private BigDecimal salario;
}

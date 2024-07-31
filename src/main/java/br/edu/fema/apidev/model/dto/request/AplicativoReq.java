package br.edu.fema.apidev.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoReq {
    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;
    @NotNull(message = "O campo empresa id é obrigatório.")
    private Long empresaId;
}

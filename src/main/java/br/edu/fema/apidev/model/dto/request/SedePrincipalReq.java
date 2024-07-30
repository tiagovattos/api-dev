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
public class SedePrincipalReq {

    @NotBlank(message = "O campo endereço é obrigatório.")
    private String endereco;

    @NotBlank(message = "O campo cidade é obrigatório.")
    private String cidade;

    @NotNull
    private Long empresaId;

}
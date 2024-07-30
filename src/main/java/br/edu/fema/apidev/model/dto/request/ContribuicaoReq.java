package br.edu.fema.apidev.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContribuicaoReq {
    @NotNull
    private Long aplicativoId;
    @NotNull
    private Long desenvolvedorId;
}

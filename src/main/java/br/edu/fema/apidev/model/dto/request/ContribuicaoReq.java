package br.edu.fema.apidev.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ContribuicaoReq {
    private Long aplicativoId;
    private Long desenvolvedorId;
}

package br.edu.fema.apidev.model.dto;

import br.edu.fema.apidev.model.Aplicativo;
import br.edu.fema.apidev.model.Contribuicao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContribuicaoDto {
    private Aplicativo aplicativo;
    private Contribuicao contribuicao;
}

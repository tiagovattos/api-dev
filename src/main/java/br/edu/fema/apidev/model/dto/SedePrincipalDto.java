package br.edu.fema.apidev.model.dto;

import br.edu.fema.apidev.model.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SedePrincipalDto {
    private Long id;
    private String endereco;
    private String cidade;
    private Empresa empresa;
}

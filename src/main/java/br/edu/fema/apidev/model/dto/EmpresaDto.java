package br.edu.fema.apidev.model.dto;

import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.SedePrincipal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {
    private Long id;
    private String nome;
    private Set<Desenvolvedor> desenvolvedores;
    private SedePrincipal sedePrincipal;
}

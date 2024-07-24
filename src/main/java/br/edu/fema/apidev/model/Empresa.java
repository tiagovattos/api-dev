package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @OneToMany(mappedBy = "empresa")
    private Set<Desenvolvedor> desenvolvedores;

    @OneToOne(mappedBy = "empresa")
    private SedePrincipal sedePrincipal;
}

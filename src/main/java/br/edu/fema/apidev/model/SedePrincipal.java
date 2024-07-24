package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SedePrincipal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "O campo endereço é obrigatório.")
    private String endereco;

    @NotBlank(message = "O campo cidade é obrigatório.")
    private String cidade;

    @OneToOne(optional = false)
    private Empresa empresa;
}

package br.edu.fema.apidev.model;

import jakarta.persistence.*;
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
    private String endereco;
    private String cidade;

    @OneToOne
    private Empresa empresa;
}

package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SedePrincipal that = (SedePrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "SedePrincipal{" +
                "id=" + id +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}

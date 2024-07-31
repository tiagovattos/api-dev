package br.edu.fema.apidev.model;

import br.edu.fema.apidev.model.enums.Contrato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Desenvolvedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;

    @ManyToOne
    private Empresa empresa;

//    @ManyToMany(mappedBy = "desenvolvedores")
    @OneToMany(mappedBy = "desenvolvedor")
    private List<Contribuicao> contribuicoes = new ArrayList<>();

    private LocalDate dataNascimento;
    private Contrato contrato;
    private BigDecimal salario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desenvolvedor that = (Desenvolvedor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Desenvolvedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", empresa=" + empresa +
                ", dataNascimento=" + dataNascimento +
                ", contrato=" + contrato +
                ", salario=" + salario +
                '}';
    }
}

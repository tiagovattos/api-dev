package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    @ManyToOne
    private Empresa empresa;

//    @ManyToMany
    @OneToMany(mappedBy = "aplicativo")
    private List<Contribuicao> contribuicoes = new ArrayList<>();

    private LocalDateTime ultimaAtualizacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aplicativo that = (Aplicativo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

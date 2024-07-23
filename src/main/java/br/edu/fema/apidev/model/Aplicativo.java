package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

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
    private Set<Contribuicao> contribuicoes;

    private LocalDateTime ultimaAtualizacao;

}

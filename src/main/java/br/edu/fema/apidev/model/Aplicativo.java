package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
//@EntityListeners(AuditingEntityListener.class)
public class Aplicativo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @ManyToOne
    private Empresa empresa;

//    @ManyToMany
    @OneToMany(mappedBy = "aplicativo")
    private Set<Contribuicao> contribuicoes;

    @LastModifiedDate
    private LocalDateTime ultimaAtualizacao;

}

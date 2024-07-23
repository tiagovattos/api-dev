package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Contribuicao {
    @EmbeddedId
    private ContribuicaoId contribuicaoId;

    @ManyToOne
    @MapsId("aplicativoId")
    private Aplicativo aplicativo;

    @ManyToOne
    @MapsId("desenvolvedorId")
    private Desenvolvedor desenvolvedor;

}

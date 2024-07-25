package br.edu.fema.apidev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Embeddable
@Entity
@Table
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Contribuicao {
    @EmbeddedId
    private ContribuicaoId contribuicaoId;

    @ManyToOne(optional = false)
    @MapsId("aplicativoId")
    private Aplicativo aplicativo;

    @ManyToOne(optional = false)
    @MapsId("desenvolvedorId")
    private Desenvolvedor desenvolvedor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contribuicao that = (Contribuicao) o;
        return Objects.equals(contribuicaoId, that.contribuicaoId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(contribuicaoId);
    }

    @Override
    public String toString() {
        return "Contribuicao{" +
                "aplicativo=" + aplicativo +
                ", desenvolvedor=" + desenvolvedor +
                '}';
    }
}

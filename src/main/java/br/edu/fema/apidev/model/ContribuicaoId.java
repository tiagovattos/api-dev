package br.edu.fema.apidev.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContribuicaoId implements Serializable {
    private Long aplicativoId;
    private Long desenvolvedorId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContribuicaoId that = (ContribuicaoId) o;
        return Objects.equals(aplicativoId, that.aplicativoId) && Objects.equals(desenvolvedorId, that.desenvolvedorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aplicativoId, desenvolvedorId);
    }
}

package br.edu.fema.apidev.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SedePrincipalRes (
        Long id,
        String endereco,
        String cidade,
        @JsonProperty("empresa") EmpresaRes empresaRes
){}

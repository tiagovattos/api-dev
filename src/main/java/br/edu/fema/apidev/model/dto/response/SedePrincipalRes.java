package br.edu.fema.apidev.model.dto.response;

public record SedePrincipalRes (
        Long id,
        String endereco,
        String cidade,
        String nomeEmpresa
){}

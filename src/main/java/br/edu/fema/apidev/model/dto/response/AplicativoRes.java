package br.edu.fema.apidev.model.dto.response;

public record AplicativoRes(
        Long id,
        String nome,
        String nomeEmpresa,
        String ultimaAtualizacao
){}

package br.edu.fema.apidev.model.dto.response;

import java.time.LocalDateTime;

public record AplicativoRes(
        Long id,
        String nome,
        EmpresaRes empresa,
        LocalDateTime ultimaAtualizacao
){}

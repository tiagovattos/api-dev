package br.edu.fema.apidev.model.dto.response;

import java.time.LocalDate;

public record DesenvolvedorRes(
        Long id,
        String nome,
        String nomeEmpresa,
        LocalDate dataNascimento
){}

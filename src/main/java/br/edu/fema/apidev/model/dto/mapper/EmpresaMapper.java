package br.edu.fema.apidev.model.dto.mapper;

import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.dto.request.EmpresaReq;
import br.edu.fema.apidev.model.dto.response.EmpresaRes;

public class EmpresaMapper {

    public static EmpresaRes toDto(Empresa empresa) {
        return new EmpresaRes(
                empresa.getId(),
                empresa.getNome()
        );
    }

    public static Empresa mapEntity(EmpresaReq empresaReq, Empresa empresa) {
        empresa.setNome(empresaReq.getNome());
        return empresa;
    }
}

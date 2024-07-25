package br.edu.fema.apidev.model.dto.mapper;

import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.SedePrincipal;
import br.edu.fema.apidev.model.dto.request.SedePrincipalReq;
import br.edu.fema.apidev.model.dto.response.SedePrincipalRes;

public class SedePrincipalMapper {

    public static SedePrincipalRes toDto(SedePrincipal sedePrincipal, Empresa empresa) {
        return new SedePrincipalRes(
                sedePrincipal.getId(),
                sedePrincipal.getEndereco(),
                sedePrincipal.getCidade(),
                EmpresaMapper.toDto(empresa)
        );
    }

    public static SedePrincipal toEntity(SedePrincipalReq req, SedePrincipal sedePrincipal, Empresa empresa) {
        sedePrincipal.setEndereco(req.getEndereco());
        sedePrincipal.setCidade(req.getCidade());
        sedePrincipal.setEmpresa(empresa);
        return sedePrincipal;
    }
}

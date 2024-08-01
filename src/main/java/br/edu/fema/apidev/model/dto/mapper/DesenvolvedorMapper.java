package br.edu.fema.apidev.model.dto.mapper;

import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.Empresa;
import br.edu.fema.apidev.model.dto.request.DesenvolvedorReq;
import br.edu.fema.apidev.model.dto.response.DesenvolvedorRes;
import br.edu.fema.apidev.utils.LocalDateFormatter;

public class DesenvolvedorMapper {
    public static DesenvolvedorRes toDto(Desenvolvedor desenvolvedor, Empresa empresa) {
        return new DesenvolvedorRes(
                desenvolvedor.getId(),
                desenvolvedor.getNome(),
                empresa.getNome(),
                LocalDateFormatter.dateToString(desenvolvedor.getDataNascimento())
        );
    }

    public static Desenvolvedor mapEntity(DesenvolvedorReq desenvolvedorReq,
                                          Desenvolvedor desenvolvedor,
                                          Empresa empresa) {
        desenvolvedor.setNome(desenvolvedorReq.getNome());
        desenvolvedor.setEmpresa(empresa);
        desenvolvedor.setDataNascimento(LocalDateFormatter.toLocalDate(desenvolvedorReq.getDataNascimento()));
        desenvolvedor.setContrato(desenvolvedorReq.getContrato());
        desenvolvedor.setSalario(desenvolvedorReq.getSalario());
        return desenvolvedor;
    }
}

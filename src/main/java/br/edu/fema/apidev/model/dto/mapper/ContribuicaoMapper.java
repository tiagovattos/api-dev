package br.edu.fema.apidev.model.dto.mapper;

import br.edu.fema.apidev.model.Aplicativo;
import br.edu.fema.apidev.model.Contribuicao;
import br.edu.fema.apidev.model.ContribuicaoId;
import br.edu.fema.apidev.model.Desenvolvedor;
import br.edu.fema.apidev.model.dto.response.ContribuicaoRes;

public class ContribuicaoMapper {
    public static ContribuicaoRes toDto(Aplicativo aplicativo, Desenvolvedor desenvolvedor) {
        return new ContribuicaoRes(
                AplicativoMapper.toDto(aplicativo, aplicativo.getEmpresa()),
                DesenvolvedorMapper.toDto(desenvolvedor, desenvolvedor.getEmpresa())
        );
    }

    public static Contribuicao mapEntity(Contribuicao contribuicao,
                                         Aplicativo aplicativo,
                                         Desenvolvedor desenvolvedor
                                          ) {
        ContribuicaoId contribuicaoId = new ContribuicaoId(aplicativo.getId(), desenvolvedor.getId());
        contribuicao.setContribuicaoId(contribuicaoId);
        contribuicao.setAplicativo(aplicativo);
        contribuicao.setDesenvolvedor(desenvolvedor);

        return contribuicao;
    }
}

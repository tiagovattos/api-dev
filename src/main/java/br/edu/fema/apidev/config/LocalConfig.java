package br.edu.fema.apidev.config;

import br.edu.fema.apidev.model.*;
import br.edu.fema.apidev.model.dto.request.*;
import br.edu.fema.apidev.model.enums.Contrato;
import br.edu.fema.apidev.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@Profile("local")
public class LocalConfig {
    private final EmpresaService empresaService;
    private final DesenvolvedorService desenvolvedorService;
    private final AplicativoService aplicativoService;
    private final SedePrincipalService sedePrincipalService;
    private final ContribuicaoService contribuicaoService;

    public LocalConfig(EmpresaService empresaService, DesenvolvedorService desenvolvedorService, AplicativoService aplicativoService, SedePrincipalService sedePrincipalService, ContribuicaoService contribuicaoService) {
        this.empresaService = empresaService;
        this.desenvolvedorService = desenvolvedorService;
        this.aplicativoService = aplicativoService;
        this.sedePrincipalService = sedePrincipalService;
        this.contribuicaoService = contribuicaoService;
    }

    @PostConstruct
    public void startDb() {
        Empresa e1 = empresaService.save(new EmpresaReq("Amazon"));
        Empresa e2 = empresaService.save(new EmpresaReq("Apple"));
        Empresa e3 = empresaService.save(new EmpresaReq("Xiaomi"));

        Desenvolvedor d1 = desenvolvedorService.save(new DesenvolvedorReq("Tiago Zamboni", 1L, LocalDate.of(2004, 5, 2), Contrato.CLT, BigDecimal.valueOf(20000)));
        Desenvolvedor d2 = desenvolvedorService.save(new DesenvolvedorReq("Pedro Zamboni", 2L, LocalDate.of(2017, 2, 16), Contrato.CLT, BigDecimal.valueOf(2300)));
        Desenvolvedor d3 = desenvolvedorService.save(new DesenvolvedorReq("Andre Zamboni", 3L, LocalDate.of(1999, 5, 25), Contrato.PJ, BigDecimal.valueOf(1500)));

        Aplicativo a1 = aplicativoService.save(new AplicativoReq("Amazon Prime Video", 1L));
        Aplicativo a2 = aplicativoService.save(new AplicativoReq("Apple Music", 2L));
        Aplicativo a3 = aplicativoService.save(new AplicativoReq("Xin Xain", 3L));

        SedePrincipal sp1 = sedePrincipalService.save(new SedePrincipalReq("Avenida Rui Barbosa 1019", "Assis", 1L));
        SedePrincipal sp2 = sedePrincipalService.save(new SedePrincipalReq("Avenida Paulista 28", "São Paulo", 2L));
        SedePrincipal sp3 = sedePrincipalService.save(new SedePrincipalReq("Rua dos Marceneiros 298", "Bombinhas", 3L));

        Contribuicao c1 = contribuicaoService.save(new ContribuicaoReq(1L, 1L));
        Contribuicao c2 = contribuicaoService.save(new ContribuicaoReq(2L, 2L));
        Contribuicao c3 = contribuicaoService.save(new ContribuicaoReq(2L, 3L));
        Contribuicao c4 = contribuicaoService.save(new ContribuicaoReq(3L, 3L));

        e1.setSedePrincipal(sp1);
        e2.setSedePrincipal(sp2);
        e3.setSedePrincipal(sp3);

        e1.getDesenvolvedores().add(d1);
        e2.getDesenvolvedores().add(d2);
        e3.getDesenvolvedores().add(d3);

        d1.getContribuicoes().add(c1);
        d2.getContribuicoes().add(c2);
        d3.getContribuicoes().add(c3);
        d3.getContribuicoes().add(c4);

        a1.getContribuicoes().add(c1);
        a2.getContribuicoes().add(c2);
        a2.getContribuicoes().add(c3);
        a3.getContribuicoes().add(c4);

    }
}

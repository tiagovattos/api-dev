package br.edu.fema.apidev.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalConfig {

    @PostConstruct
    public void startDb(){

    }
}

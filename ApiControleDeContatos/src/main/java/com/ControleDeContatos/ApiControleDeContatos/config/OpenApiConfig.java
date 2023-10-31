package com.ControleDeContatos.ApiControleDeContatos.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                        .title("API Controle de Cadastro")
                        .description("Uma API Rest para Controle de Contatos, que gerencia um sitema de cadastro de Pessoas e " +
                                "seus respectivos Contatos. Um dos objetivo da nossa API é permitir que operações CRUD - com o " +
                                "uso dos métodos HTTP GET, POST, PUT e DELETE sejam realizadas. A API estará conectada ao banco de dados MySQL.")
                        .contact(new Contact().name("José Felipe Alexandre Martins").email("josefelipealexandre1997@gmail.com").url("https://github.com/felipealx1/Projeto_Final_Minsait_ControleDeContatos_Backend/tree/main"))
                        .version("Versão 0.0.1-SNAPSHOT"));
    }
}

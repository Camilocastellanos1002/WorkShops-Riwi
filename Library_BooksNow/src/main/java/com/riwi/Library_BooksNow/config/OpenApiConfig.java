package com.riwi.Library_BooksNow.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API para administrar entidades (usuarios, libros , prestamos, reservas)",
        version = "1.0",
        description = "Documentacion API de administrar libreria"
    ))
public class OpenApiConfig {
    
}

package com.thomazllr.tickets.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Tickets API", version = "1.0",
        contact = @Contact(name = "Guilherme Thomaz", email = "thomazllrdev@gmail.com")))
public class OpenApiConfig {
}

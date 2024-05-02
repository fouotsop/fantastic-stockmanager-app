package com.hivcaremanager.stockmanagement.config.swaggerui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
   
    private final String devUrl = "http://localhost:8888";

       @Bean
    public OpenAPI openApi() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server url for development environment");


        Contact contact = new Contact();
        contact.setEmail("patrick.fouotsop@facsciences-uy1.cm");
        contact.setName("Patrick Fouotsop");
        contact.setUrl("https://fouotsop.github.io/portfolio");

        License mitLicense = new License().name("MIT License").url("https://opensource.org/licenses/MIT");
        Info info = new Info()
                .title("Stock management module for the project HIV care manager")
                .description("This module is responsible for managing vaccins present in health facilities for the project hiv care manager")
                .version("1.0.0")
                .contact(contact)
                .license(mitLicense);

        return new OpenAPI().info(info)
                .addServersItem(devServer);
              
    }
}

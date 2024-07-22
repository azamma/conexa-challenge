package com.azamma.conexa;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ConexaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConexaApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {

        final String securitySchemeName = "BearerAuthentication";

        return new OpenAPI()
                .info(new Info()
                        .title("Conexa Challenge")
                        .version("v1.0.0")
                        .description("Challenge de integración de api de Conexa")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
                /* .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName));*/
    }
    
}

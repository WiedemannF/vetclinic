package com.javajunior.vetclinic.vetservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Сервис ветеринарной клиники")
                        .description("Полный спектр ветеринарных услуг круглосуточно!")
                        .version("1.0")
                        .contact(new Contact().name("Fedor Wiedemann")
                                .email("my@email.com"))
                );
    }
}

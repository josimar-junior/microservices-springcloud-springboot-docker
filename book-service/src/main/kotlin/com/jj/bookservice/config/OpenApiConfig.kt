package com.jj.bookservice.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.License
import org.springframework.context.annotation.Bean

@OpenAPIDefinition(
    info = Info(
        title = "Book Service API",
        version = "1.0",
        description = "Documentation of Book Service API"
    )
)
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .components(Components())
            .info(
                io.swagger.v3.oas.models.info.Info()
                    .title("Book Service API")
                    .version("1.0")
                    .license(
                        License()
                            .name("JJ Softwares")
                            .url("https://github.com/josimar-junior/microservices-springcloud-springboot-docker/tree/main/book-service")
                    )
            )
    }
}
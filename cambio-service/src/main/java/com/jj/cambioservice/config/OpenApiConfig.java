package com.jj.cambioservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(
    info = @Info(
      title = "Cambio Service API",
      version = "1.0",
      description = "Documentation of Cambio Service API"
    )
)
public class OpenApiConfig {

    public OpenAPI customOpenAPI() {
      return new OpenAPI()
        .components(new Components())
          .info(
            new io.swagger.v3.oas.models.info.Info()
              .title("Cambio Service API")
              .version("1.0")
              .license(
                new License()
                  .name("JJ Softwares")
                  .url("https://github.com/josimar-junior/microservices-springcloud-springboot-docker/tree/main/cambio-service")
              )
          );
    }
}

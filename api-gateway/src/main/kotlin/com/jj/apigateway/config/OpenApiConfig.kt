package com.jj.apigateway.config

import org.springdoc.core.GroupedOpenApi
import org.springdoc.core.SwaggerUiConfigParameters
import org.springframework.cloud.gateway.route.RouteDefinitionLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

@Configuration
class OpenApiConfig {

    @Bean
    @Lazy(false)
    fun apis(
        config: SwaggerUiConfigParameters,
        locator: RouteDefinitionLocator
    ): List<GroupedOpenApi> {
        val definitions = locator.routeDefinitions.collectList().block()
        definitions?.filter {
            routeDefinition -> routeDefinition.id.matches(Regex(".*-service"))
        }?.forEach {
            val name = it.id
            config.addGroup(name)
            GroupedOpenApi.builder()
                .pathsToMatch("/" + name + "/**")
                .group(name).build()
        }
        return listOf()
    }
}
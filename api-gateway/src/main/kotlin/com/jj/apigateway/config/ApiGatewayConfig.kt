package com.jj.apigateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
class ApiGatewayConfig {}

    /*@Bean
    fun gatewayRouter(builder: RouteLocatorBuilder): RouteLocator  =
        builder.routes {
            route {
                path("/cambio-service/**")
                uri("lb://cambio-service")
            }
            route {
                path("/book-service/**")
                uri("lb://book-service")
            }
        }*/
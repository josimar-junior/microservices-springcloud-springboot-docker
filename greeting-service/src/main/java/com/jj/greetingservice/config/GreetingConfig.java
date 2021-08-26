package com.jj.greetingservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@ConfigurationProperties("greeting-service")
@Getter
@Setter
public class GreetingConfig {
    private String greeting;
    private String defaultValue;
}

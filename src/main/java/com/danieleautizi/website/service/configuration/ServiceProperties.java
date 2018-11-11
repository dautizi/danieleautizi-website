package com.danieleautizi.website.service.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    private String personalDataService = "http://localhost:3000/personal-data-service";
}

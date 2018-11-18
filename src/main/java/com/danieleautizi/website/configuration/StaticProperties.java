package com.danieleautizi.website.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for Static resources.
 */
@Data
@Component
@ConfigurationProperties("static")
public class StaticProperties {

    private String baseUrl;
    private String adminBaseUrl;
    private String staticBaseUrl;
}

package com.danieleautizi.website.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for Geo Location tracking.
 */
@Data
@Component
@ConfigurationProperties("geolocation")
public class GeoLocationProperties {

    private String baseUrl;
}

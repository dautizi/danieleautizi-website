package com.danieleautizi.website.configuration;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for server requests.
 */
@Data
@Component
@ConfigurationProperties("remote.pool")
public class PoolProperties {

    private int maxConnectionsPerRoute = 4;
    private int maxConnections = 16;
    private int connectionRequestTimeout = 5000;
    private int connectionTimeout = 5000;
    private int socketReadTimeout = 15000;
}

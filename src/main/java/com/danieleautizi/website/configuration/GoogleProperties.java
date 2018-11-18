package com.danieleautizi.website.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for Social networks API.
 */
@Data
@Component
@ConfigurationProperties("google")
public class GoogleProperties {

    private ReCaptchaConfig recaptcha = new ReCaptchaConfig();
    private MapConfig map = new MapConfig();

    @Data
    @NoArgsConstructor
    public static class ReCaptchaConfig {

        private String siteKey;
        private String secretKey;
    }

    @Data
    @NoArgsConstructor
    public static class MapConfig {

        private String latitude;
        private Integer longitude;
        private Integer zoom;
        private String apiKey;
    }
}

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
@ConfigurationProperties("social")
public class SocialProperties {

    private InstagramConfig instagram = new InstagramConfig();
    private SpotifyConfig spotify = new SpotifyConfig();
    private LinkedinConfig linkedin = new LinkedinConfig();
    private GooglePlusConfig googlePlus = new GooglePlusConfig();

    @Data
    @NoArgsConstructor
    public static class InstagramConfig {

        private String host;
        private String version;
        private String clientId;
        private String clientSecret;
        private String redirectURI;
    }

    @Data
    @NoArgsConstructor
    public static class SpotifyConfig {

        private String scheme;
        private Integer port;
        private String host;
        private String accessToken;
        private String refreshToken;
        private String clientId;
        private String clientSecret;
        private String redirectURI;
    }

    @Data
    @NoArgsConstructor
    public static class LinkedinConfig {

        private String host;
        private String version;
        private String clientId;
        private String clientSecret;
        private String redirectURI;
    }

    @Data
    @NoArgsConstructor
    public static class GooglePlusConfig {

        private String siteHost;
        private Integer port;
        private String authUri;
        private String tokenUri;
        private String authProviderX509CertUrl;
        private String version;
        private String projectId;
        private String clientId;
        private String jsonFile;
        private String clientSecret;
        private String redirectURI;
        private String redirectURIsInput;
        private String dataFolder;
    }
}

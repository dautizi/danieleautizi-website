package com.danieleautizi.website.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Configuration properties for Mailing.
 */
@Data
@Component
@ConfigurationProperties("mailing")
public class MailingProperties {


    private String receiver;
    private SenderConfig sender = new SenderConfig();
    private Smtp smtp = new Smtp();

    @Data
    @NoArgsConstructor
    public static class SenderConfig {

        private String usr;
        private String pwd;
    }

    @Data
    @NoArgsConstructor
    public static class Smtp {

        private Ssl ssl;
        private Tsl tsl;
    }

    @Data
    @NoArgsConstructor
    public static class Ssl {

        private String host;
        private SocketFactory socketFactory;
        private String auth;
        private Integer port;
    }

    @Data
    @NoArgsConstructor
    public static class SocketFactory {

        private Integer port;
        private String factoryClass;
    }

    @Data
    @NoArgsConstructor
    public static class Tsl {

        private String host;
        private StartTlsy starttlsy;
        private String auth;
        private Integer port;
    }

    @Data
    @NoArgsConstructor
    public static class StartTlsy {

        private Boolean enable;
    }

}

package com.danieleautizi.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DanieleAutiziApplication {

    public static void main(String[] args) {
		SpringApplication.run(DanieleAutiziApplication.class, args);
	}
}

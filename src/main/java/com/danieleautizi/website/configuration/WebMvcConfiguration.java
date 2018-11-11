package com.danieleautizi.website.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
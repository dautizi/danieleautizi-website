package com.danieleautizi.website.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Server specific configuration
 */
@Configuration
@RequiredArgsConstructor
public class ServerConfiguration {

    @NonNull
    private final PoolProperties poolProperties;

    @Bean
    public ObjectMapper objectMapper() {

        return Jackson2ObjectMapperBuilder.json()
                                          .indentOutput(false)
                                          .featuresToEnable(SerializationFeature.WRITE_NULL_MAP_VALUES,
                                                            SerializationFeature.WRITE_ENUMS_USING_TO_STRING,
                                                            DeserializationFeature.READ_ENUMS_USING_TO_STRING,
                                                            SerializationFeature.FLUSH_AFTER_WRITE_VALUE)
                                          .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                                                             SerializationFeature.WRAP_ROOT_VALUE,
                                                             DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS,
                                                             DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE)
                                          .build();
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(final ObjectMapper objectMapper) {

        val mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(objectMapper);

        val restTemplate = new RestTemplate();

        val factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(HttpClientBuilder.create()
                                               .setMaxConnPerRoute(poolProperties.getMaxConnectionsPerRoute())
                                               .setMaxConnTotal(poolProperties.getMaxConnections())
                                               .build());
        factory.setConnectionRequestTimeout(poolProperties.getConnectionRequestTimeout());
        factory.setConnectTimeout(poolProperties.getConnectionTimeout());
        factory.setReadTimeout(poolProperties.getSocketReadTimeout());

        restTemplate.setRequestFactory(factory);

        val messageConverters = restTemplate.getMessageConverters();
        messageConverters.removeIf(m -> m.getClass()
                                         .equals(MappingJackson2HttpMessageConverter.class));
        messageConverters.add(mappingJackson2HttpMessageConverter);

        return restTemplate;
   }

}

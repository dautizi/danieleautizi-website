package com.danieleautizi.website.service.utils;

import lombok.NoArgsConstructor;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Builder to create requests.
 */
@NoArgsConstructor(staticName = "start")
public class RequestBuilder {

    private final Map<String, String> params = new HashMap<>();

    public RequestBuilder put(final String name, final Object value) {

        params.put(name, Optional.ofNullable(value)
                                 .map(Object::toString)
                                 .orElse(null));
        return this;
    }

    public MultiValueMap<String, String> build() {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        params.entrySet().forEach(e -> map.add(e.getKey(), e.getValue()));

        return map;
    }

}

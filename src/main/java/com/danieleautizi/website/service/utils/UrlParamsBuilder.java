package com.danieleautizi.website.service.utils;

import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Builder to create Url parameter map with {@link Collection}s as comma separated {@link String}.
 */
@NoArgsConstructor(staticName = "start")
public class UrlParamsBuilder {

    private final Map<String, String> params = new HashMap<>();

    public UrlParamsBuilder put(final String name, final Collection<? extends CharSequence> value) {

        params.put(name, String.join(",", value));
        return this;
    }

    public UrlParamsBuilder put(final String name, final Object value) {

        params.put(name, Optional.ofNullable(value)
                                 .map(Object::toString)
                                 .orElse(null));
        return this;
    }

    public Map<String, String> build() {

        return params;
    }

}

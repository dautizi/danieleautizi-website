package com.danieleautizi.website.service.utils;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    @NonNull
    private final MessageSource messageSource;

    public String getMessage(String messageKey, Object... args) {

        return this.messageSource.getMessage(messageKey, args, messageKey, Locale.ROOT);
    }
}

package com.danieleautizi.website.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
    code = HttpStatus.INTERNAL_SERVER_ERROR
)
public class InternalServerErrorException extends AbstractStatusCodeException {

    private static final long serialVersionUID = 1L;

    public InternalServerErrorException(String msg) {
        super(msg);
    }

    public InternalServerErrorException(String msg, Throwable trbl) {
        super(msg, trbl);
    }
}
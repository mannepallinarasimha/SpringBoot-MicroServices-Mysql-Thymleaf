package com.nara.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcenotFoundException extends RuntimeException{

    private static final long serialVersionUID=1l;

    public ResourcenotFoundException(String message) {
        super(message);
    }
}

package com.nara.restdemo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CloudVendorException {
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;

    public CloudVendorException(String message, Throwable cause, HttpStatus httpStatus) {
        this.message = message;
        this.cause = cause;
        this.httpStatus = httpStatus;
    }
}

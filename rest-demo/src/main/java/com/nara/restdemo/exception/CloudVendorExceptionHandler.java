package com.nara.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //response for handling global exceptions
public class CloudVendorExceptionHandler {
    @ExceptionHandler(value = {CloudVendorNotFoundException.class}) //telling this method which should handle all exceptions
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){
        //creating payload
        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);

    }
}

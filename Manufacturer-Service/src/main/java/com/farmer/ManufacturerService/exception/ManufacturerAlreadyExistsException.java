package com.farmer.ManufacturerService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManufacturerAlreadyExistsException extends RuntimeException{

    private String message;

    public ManufacturerAlreadyExistsException(String message) {
        super();
        this.message = message;
        System.out.println(message);
    }
}

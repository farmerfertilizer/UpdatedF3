package com.farmer.UserService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerAlreadyExistsException extends RuntimeException{

    private String message;

    public CustomerAlreadyExistsException(String message) {
        super();
        this.message = message;
        System.out.println(message);
    }
}

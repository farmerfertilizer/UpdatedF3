package com.farmer.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidUserException extends RuntimeException{

    private String message;

    public InvalidUserException(String message) {
        super();
        this.message = message;
        System.out.println(message);
    }
}

package com.farmer.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNameAlreadyExistsException extends RuntimeException{
    public UserNameAlreadyExistsException(String s) {
        super(s);
    }
}

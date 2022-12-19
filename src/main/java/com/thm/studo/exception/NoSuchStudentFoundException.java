package com.thm.studo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchStudentFoundException extends RuntimeException{

    public NoSuchStudentFoundException(String message) {
        super(message);
    }
}

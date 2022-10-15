package com.thm.studo.exception;

public class NoSuchStudentFoundException extends RuntimeException{

    public NoSuchStudentFoundException(String message) {
        super(message);
    }
}

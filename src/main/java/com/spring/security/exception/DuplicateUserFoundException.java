package com.spring.security.exception;

public class DuplicateUserFoundException extends RuntimeException{

    public DuplicateUserFoundException() {
        super("Duplicate User Found Exception !!!!");
    }
}

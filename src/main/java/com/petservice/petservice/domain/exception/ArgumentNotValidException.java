package com.petservice.petservice.domain.exception;

public class ArgumentNotValidException extends RuntimeException {
    public ArgumentNotValidException(String message) {
        super(message);
    }
}

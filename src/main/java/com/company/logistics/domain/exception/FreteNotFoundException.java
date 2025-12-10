package com.company.logistics.domain.exception;


public class FreteNotFoundException extends RuntimeException {
    public FreteNotFoundException(String message) {
        super(message);
    }
}

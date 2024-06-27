package com.matiox.banking_service.exception;

public class BadRequestException extends RuntimeException {

    //Creamos dos Constructors


    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}

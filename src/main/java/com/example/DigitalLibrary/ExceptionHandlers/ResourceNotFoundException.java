package com.example.DigitalLibrary.ExceptionHandlers;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

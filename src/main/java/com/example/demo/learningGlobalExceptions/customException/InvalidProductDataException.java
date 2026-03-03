package com.example.demo.learningGlobalExceptions.customException;

public class InvalidProductDataException extends RuntimeException {
    public InvalidProductDataException(String field, String reason){
        super(String.format("Invalid field %s: %s", field, reason));
    }
}

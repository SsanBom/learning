package com.example.demo.learningGlobalExceptions.customException;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(int requested, int available){
        super(String.format("Requested %s items, but only %s available", requested, available));
    }

}

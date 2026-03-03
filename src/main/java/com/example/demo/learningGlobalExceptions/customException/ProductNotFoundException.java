package com.example.demo.learningGlobalExceptions.customException;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super(String.format("Product with id %s not found", id));
    }
}

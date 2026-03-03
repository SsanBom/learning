package com.example.demo.learningGlobalExceptions;

import com.example.demo.learningGlobalExceptions.customException.ErrorResponse;
import com.example.demo.learningGlobalExceptions.customException.InsufficientStockException;
import com.example.demo.learningGlobalExceptions.customException.InvalidProductDataException;
import com.example.demo.learningGlobalExceptions.customException.ProductNotFoundException;
import com.example.demo.learningJPA.exceptions.NotEnoughMoneyException;
import com.example.demo.learningJPA.exceptions.NotSufficientSupplyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleProductNotFound(ProductNotFoundException e){
        var errorResponse = new ErrorResponse(
             "Not found",
                e.getMessage(),
                404
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInsufficientStock(InsufficientStockException e){
        var errorResponse = new ErrorResponse(
                "Bad request",
                e.getMessage(),
                400
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidProductData(InvalidProductDataException e){
        var errorResponse = new ErrorResponse(
                "Bad request",
                e.getMessage(),
                400
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleOtherExceptions(Exception e){
        var errorResponse = new ErrorResponse(
                "Internal server error",
                e.getMessage(),
                500
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
    @ExceptionHandler
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e){
        var errorResponse = new ErrorResponse(
                "Bad request",
                e.getMessage(),
                400
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler
    public ResponseEntity<?> handleNotSufficientSupply(NotSufficientSupplyException e){
        var errorResponse = new ErrorResponse(
                "Bad request",
                e.getMessage(),
                400
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleNotEnoughMoney(NotEnoughMoneyException e){
        var errorResponse = new ErrorResponse(
                "Bad request",
                e.getMessage(),
                400
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}

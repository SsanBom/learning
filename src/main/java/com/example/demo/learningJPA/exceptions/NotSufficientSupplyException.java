package com.example.demo.learningJPA.exceptions;

public class NotSufficientSupplyException extends RuntimeException {
    public NotSufficientSupplyException(int requestedQuantity, int realQuantity, String itemName) {
        super(String.format("%s %s was requested for purchase, but only %s available", itemName, requestedQuantity, realQuantity));
    }
}

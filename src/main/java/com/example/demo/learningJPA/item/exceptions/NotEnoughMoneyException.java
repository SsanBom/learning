package com.example.demo.learningJPA.item.exceptions;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(int purchasePrice, int balance, int requestedQuantity, String itemName) {
        super(String.format("You are %s money short to buy %s %s", (balance - purchasePrice) * -1, requestedQuantity, itemName));
    }
}

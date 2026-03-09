package com.example.demo.learningJPA.item.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ItemRequest {
    @Size(min = 1, max = 20, message = "name length must be between 1 and 20 symbols")
    private String name;
    private String type;
    @Min(1)
    private int price;
    @Min(0)
    private int quantity;

    public ItemRequest(String name, String type, int price, int quantity) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

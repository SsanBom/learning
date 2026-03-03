package com.example.demo.learningGlobalExceptions;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {
    @NotNull(message = "name is null")
    @NotBlank(message = "name can`t be blank")
    private String name;

    @Min(1)
    private int price;

    @Min(1)
    private int quantity;

    public ProductRequest(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

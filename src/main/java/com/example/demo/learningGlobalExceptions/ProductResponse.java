package com.example.demo.learningGlobalExceptions;

public class ProductResponse {
    private long id;
    private String name;
    private int price;
    private int quantity;

    public ProductResponse(long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
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

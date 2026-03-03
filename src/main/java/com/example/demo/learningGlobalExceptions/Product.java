package com.example.demo.learningGlobalExceptions;


public class Product {
    private Long id;
    private String name;
    private int price;
    private int quantity;

    public Product(Long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
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
    public void setId(long id){
        this.id = id;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}

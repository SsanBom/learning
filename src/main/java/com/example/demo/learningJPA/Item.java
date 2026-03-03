package com.example.demo.learningJPA;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

@Entity
@Validated
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private int price;
    private int quantity;
    private boolean available;

    public Item(String name, String type, int price, int quantity){
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        available = quantity > 0;
    }

    public Item(){
    }

    public void setQuantity(@Min(0) int quantity){
        this.quantity = quantity;
        available = quantity > 0;
    }

    public Long getId() {
        return id;
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

    public boolean isAvailable() {
        return available;
    }
}

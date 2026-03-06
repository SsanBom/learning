package com.example.demo.learningJPA.category;


import com.example.demo.learningJPA.Item;
import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Validated
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Item> items;

    public Category(){}

    public Category(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }
}

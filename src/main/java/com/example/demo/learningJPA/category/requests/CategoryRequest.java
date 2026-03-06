package com.example.demo.learningJPA.category.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryRequest {
    @NotNull
    @Size(min = 3, max = 15, message = "name size not sufficient")
    private String name;

    @NotNull
    @Size(min = 3, max = 40, message = "name size not sufficient")
    private String description;

    public CategoryRequest(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

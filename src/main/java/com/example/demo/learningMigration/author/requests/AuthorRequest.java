package com.example.demo.learningMigration.author.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthorRequest {
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Integer birthyear;

    public AuthorRequest(Long id, String name, Integer birthyear) {
        this.id = id;
        this.name = name;
        this.birthyear = birthyear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthyear() {
        return birthyear;
    }
}

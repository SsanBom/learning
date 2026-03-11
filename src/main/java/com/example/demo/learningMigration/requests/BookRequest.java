package com.example.demo.learningMigration.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequest {
    private Long id;

    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String authorName;

    @NotNull
    @NotBlank
    private String genre;

    @Min(1)
    private int year;

    @Min(1)
    private int pages;

    public BookRequest() {}


    public BookRequest(Long id, String title, String authorName, String genre, int year, int pages) {
        this.id = id;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.year = year;
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

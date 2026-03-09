package com.example.demo.learningMigration.exceptions;

public class InvalidBookGenreException extends RuntimeException {
    public InvalidBookGenreException(String genre) {
        super(String.format("Genre %s is not allowed here. Allowed genres are in application.yml: app.validation.valid_book_genres", genre));
    }
}

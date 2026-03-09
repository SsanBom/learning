package com.example.demo.learningMigration.exceptions;

public class InvalidYearException extends RuntimeException {
    public InvalidYearException(int year) {
        super(String.format("Invalid year format. Year %s is invalid. ", year));
    }
}

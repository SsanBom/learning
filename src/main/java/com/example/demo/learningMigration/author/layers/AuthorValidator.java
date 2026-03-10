package com.example.demo.learningMigration.author.layers;


import com.example.demo.learningMigration.author.requests.AuthorRequest;
import com.example.demo.learningMigration.exceptions.InvalidYearException;

import java.time.LocalDate;

public class AuthorValidator {
    public void validate(AuthorRequest request){
        if (request.getBirthyear() > LocalDate.now().getYear()){
            throw new InvalidYearException(request.getBirthyear());
        }
    }
}

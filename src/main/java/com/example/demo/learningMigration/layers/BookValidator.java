package com.example.demo.learningMigration.layers;

import com.example.demo.learningMigration.Book;
import com.example.demo.learningMigration.exceptions.InvalidBookGenreException;
import com.example.demo.learningMigration.exceptions.InvalidYearException;
import com.example.demo.learningMigration.requests.BookRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BookValidator {

    @Value("${app.validation.valid_book_genres}")
    private List<String> validGenreTypes;

    public void validateCreate(BookRequest request){
        validateGenre(request.getGenre());
        validateYear(request.getYear());
    }

    public void validateUpdate(BookRequest request, Book book){
        validateCreate(request);
        if (book == null){throw new RuntimeException();} //Тут правда лень было свою ошибку писать
    }

    private void validateGenre(String genre){
        if (!validGenreTypes.contains(genre)){
            throw new InvalidBookGenreException(genre);
        }
    }

    private void validateYear(int year){
        if (year > LocalDate.now().getYear()){
            throw new InvalidYearException(year);
        }
    }

}

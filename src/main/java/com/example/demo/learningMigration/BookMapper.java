package com.example.demo.learningMigration;

import com.example.demo.learningMigration.requests.BookRequest;
import com.example.demo.learningMigration.responses.BookResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface BookMapper {
    public Book requestToBook(BookRequest request);
    public BookResponse bookToResponse(Book book);

}

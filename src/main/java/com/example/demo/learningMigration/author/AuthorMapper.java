package com.example.demo.learningMigration.author;

import com.example.demo.learningMigration.author.requests.AuthorRequest;
import com.example.demo.learningMigration.author.responses.AuthorResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AuthorMapper {
    public Author requestToAuthor(AuthorRequest request);
    public AuthorResponse authorToResponse(Author author);
}

package com.example.demo.learningMigration.author.layers;

import com.example.demo.learningMigration.author.Author;
import com.example.demo.learningMigration.author.AuthorMapper;
import com.example.demo.learningMigration.author.requests.AuthorRequest;
import com.example.demo.learningMigration.author.responses.AuthorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository repository;
    private AuthorMapper mapper;
    private AuthorValidator validator;

    public AuthorService(AuthorRepository repository, AuthorMapper mapper, AuthorValidator validator){
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public AuthorResponse create(AuthorRequest request){
        validator.validate(request);
        Author author = mapper.requestToAuthor(request);
        return mapper.authorToResponse(repository.save(author));
    }

    public List<AuthorResponse> getAll(){
        return repository
                .findAll()
                .stream()
                .map(mapper::authorToResponse)
                .toList();
    }

}

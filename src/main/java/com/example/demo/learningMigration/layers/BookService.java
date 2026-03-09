package com.example.demo.learningMigration.layers;

import com.example.demo.learningMigration.Book;
import com.example.demo.learningMigration.BookMapper;
import com.example.demo.learningMigration.requests.BookRequest;
import com.example.demo.learningMigration.responses.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    private final BookMapper mapper;
    private final BookValidator validator;

    public BookService(BookRepository repository, BookMapper mapper, BookValidator validator){
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public BookResponse createBook(BookRequest request){
        validator.validateCreate(request);
        Book book = mapper.requestToBook(request);
        return mapper.bookToResponse(repository.save(book));
    }

    public List<BookResponse> getAll(){
        return repository.findAll().stream()
                .map(mapper::bookToResponse)
                .toList();
    }

    public BookResponse delete(Long id){
        Book book = repository.findById(id).orElseThrow();
        repository.delete(book);
        return mapper.bookToResponse(book);
    }

    public BookResponse update(BookRequest request){
        Book bookInsideTable = repository.findById(request.getId()).orElseThrow();
        validator.validateUpdate(request, bookInsideTable);
        Book requestBook = mapper.requestToBook(request);
        return mapper.bookToResponse(repository.save(requestBook));
    }
}

package com.example.demo.learningMigration.layers;

import com.example.demo.learningMigration.Book;
import com.example.demo.learningMigration.BookMapper;
import com.example.demo.learningMigration.author.Author;
import com.example.demo.learningMigration.author.layers.AuthorRepository;
import com.example.demo.learningMigration.requests.BookRequest;
import com.example.demo.learningMigration.responses.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper mapper;
    private final BookValidator validator;

    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, BookMapper mapper, BookValidator validator, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.mapper = mapper;
        this.validator = validator;
        this.authorRepository = authorRepository;
    }

    public BookResponse createBook(BookRequest request){
        validator.validateCreate(request);
        Author author = authorRepository.findByName(request.getAuthorName());
        Book book = mapper.requestToBook(request);
        book.setAuthor(author);
        return mapper.bookToResponse(bookRepository.save(book));
    }

    public List<BookResponse> getAll(){
        return bookRepository.findAll().stream()
                .map(mapper::bookToResponse)
                .toList();
    }

    public BookResponse delete(Long id){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return mapper.bookToResponse(book);
    }

    public BookResponse update(BookRequest request){
        Book bookInsideTable = bookRepository.findById(request.getId()).orElseThrow();
        validator.validateUpdate(request, bookInsideTable);
        Book requestBook = mapper.requestToBook(request);
        return mapper.bookToResponse(bookRepository.save(requestBook));
    }
}

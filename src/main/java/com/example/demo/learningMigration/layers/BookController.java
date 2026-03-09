package com.example.demo.learningMigration.layers;

import com.example.demo.learningMigration.requests.BookRequest;
import com.example.demo.learningMigration.responses.BookResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BookRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBook(request));
    }

    @GetMapping("/all")
    public List<BookResponse> getAll(){
        return service.getAll();
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody BookRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(request));
    }
}

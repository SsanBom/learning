package com.example.demo.learningMigration.author.layers;

import com.example.demo.learningMigration.author.requests.AuthorRequest;
import com.example.demo.learningMigration.author.responses.AuthorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/authors")
public class AuthorController {
    private AuthorService service;

    public AuthorController(AuthorService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody AuthorRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/all")
    public List<AuthorResponse> getAll(){
        return service.getAll();
    }

}

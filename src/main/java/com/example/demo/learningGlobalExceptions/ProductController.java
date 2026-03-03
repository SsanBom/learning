package com.example.demo.learningGlobalExceptions;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    public ProductService service;

    @GetMapping("/api/product/{id}")
    public ProductResponse getProduct(@PathVariable long id){
        return service.getProduct(id);
    }
    @PostMapping("/api/product")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest request){
        service.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
    @PutMapping("/api/product/buy")
    public ResponseEntity<?> buyProduct(@RequestParam long id, @RequestParam int quantity){
        service.buyProduct(id, quantity);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("successfully bought item id:%s in quantity:%s", id, quantity));
    }
}

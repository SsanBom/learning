package com.example.demo.learningJPA.category;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService service;
    public CategoryController(CategoryService service){
        this.service = service;
    }




}

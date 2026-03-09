package com.example.demo.learningJPA.category;

import com.example.demo.learningJPA.category.requests.CategoryRequest;
import com.example.demo.learningJPA.category.response.CategoryResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository repository;
    private CategoryMapper mapper;


    public CategoryService(CategoryRepository repository, CategoryMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

//    public CategoryResponse createCategory (CategoryRequest request){
//        repository.save(mapper.categoryRequestToCategory(request));
//    }
}

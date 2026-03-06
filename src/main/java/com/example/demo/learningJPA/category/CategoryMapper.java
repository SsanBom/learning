package com.example.demo.learningJPA.category;

import com.example.demo.learningJPA.category.requests.CategoryRequest;
import com.example.demo.learningJPA.category.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {
    public CategoryResponse categoryToCategoryResponse(Category category);
    public Category categoryRequestToCategory(CategoryRequest request);
}

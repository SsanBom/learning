package com.example.demo.learningGlobalExceptions;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);
    Product toProduct(ProductRequest productRequest);
}

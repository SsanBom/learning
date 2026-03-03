package com.example.demo.learningGlobalExceptions;

import com.example.demo.learningGlobalExceptions.customException.InsufficientStockException;
import com.example.demo.learningGlobalExceptions.customException.InvalidProductDataException;
import com.example.demo.learningGlobalExceptions.customException.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;
    @Autowired
    ProductMapper mapper;

    public ProductResponse getProduct(long id){
        return mapper.toResponse(repository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }
    public void createProduct(ProductRequest request){
        if (request.getName() == null || request.getName().isEmpty()){
            throw new InvalidProductDataException("name", "is empty");
        }
        else if (request.getPrice() <= 0){
            throw new InvalidProductDataException("price", "is zero or lower");
        }
        else if (request.getQuantity() <= 0){
            throw new InvalidProductDataException("quantity", "is zero or lower");
        }
        else {
            repository.save(mapper.toProduct(request));
        }
    }

    public void buyProduct(long id, int quantity){
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        int resultQuantity = product.getQuantity() - quantity;
        if (resultQuantity < 0){
            throw new InsufficientStockException(quantity, product.getQuantity());
        }
        else {
            product.setQuantity(resultQuantity);
            repository.save(product);
        }
    }

}

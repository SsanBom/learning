package com.example.demo.learningGlobalExceptions;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private Map<Long, Product> products = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong(1);

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idCounter.getAndIncrement());
        }
        products.put(product.getId(), product);
        return product;
    }

    public void deleteById(Long id) {
        products.remove(id);
    }
}

package com.example.demo.learningJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByType(String type);
    List<Item> findByPriceBetween(int min, int max);
    List<Item> findByAvailableTrue();

    @Query("SELECT i FROM Item i WHERE i.quantity < :threshold")
    List<Item> findLowStock(@Param("threshold") int threshold);
}

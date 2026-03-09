package com.example.demo.learningMigration.layers;

import com.example.demo.learningMigration.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

package com.example.demo.learningMigration.author.layers;

import com.example.demo.learningMigration.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    public Author findByName(String name);
}

package com.example.demo.learningMigration.author;

import com.example.demo.learningMigration.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int birthYear;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author(Long id, String name, int birthYear){
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public Author(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public List<Book> getBooks() {
        return books;
    }
}

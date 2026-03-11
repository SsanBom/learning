package com.example.demo.learningMigration;

import com.example.demo.learningMigration.author.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Setter
    private Author author;

    private String genre;

    private int year;

    private int pages;

    public Book(Long id, String title, String genre, int year, int pages) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.pages = pages;
    }
}

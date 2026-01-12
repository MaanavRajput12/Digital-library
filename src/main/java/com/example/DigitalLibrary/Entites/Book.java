package com.example.DigitalLibrary.Entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private String category;

    @Column(nullable = false)
    private int totalCopies;

    @Column(nullable = false)
    private int availableCopies;

    public Book() {}

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public String getCategory() {
        return category;
    }
 
    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalCopies() {
        return totalCopies;
    }
 
    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
 
    public int getAvailableCopies() {
        return availableCopies;
    }
 
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}

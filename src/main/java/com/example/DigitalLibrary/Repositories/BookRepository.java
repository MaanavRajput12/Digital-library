package com.example.DigitalLibrary.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DigitalLibrary.Entites.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByCategory(String category);

    List<Book> findByAuthorContainingIgnoreCase(String author);
}

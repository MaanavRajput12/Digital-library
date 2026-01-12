package com.example.DigitalLibrary.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DigitalLibrary.Entites.Book;
import com.example.DigitalLibrary.ExceptionHandlers.BadRequestException;
import com.example.DigitalLibrary.ExceptionHandlers.ResourceNotFoundException;
import com.example.DigitalLibrary.Repositories.BookRepository;

@Service
public class BookServices {

    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        if (book == null) {
            throw new BadRequestException("Book cannot be null");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Long bookId, Book updatedBook) {
        if (bookId == null || updatedBook == null) {
            throw new BadRequestException("Book ID or data cannot be null");
        }

        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + bookId));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setCategory(updatedBook.getCategory());
        existingBook.setAvailableCopies(updatedBook.getAvailableCopies());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long bookId) {
        if (bookId == null) {
            throw new BadRequestException("Book ID cannot be null");
        }

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + bookId));

        bookRepository.delete(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

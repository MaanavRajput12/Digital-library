package com.example.DigitalLibrary.Services;

import org.springframework.stereotype.Service;

import com.example.DigitalLibrary.DTOs.Admin.BookRequestDTO;
import com.example.DigitalLibrary.Entites.Book;
import com.example.DigitalLibrary.ExceptionHandlers.BadRequestException;
import com.example.DigitalLibrary.ExceptionHandlers.ResourceNotFoundException;
import com.example.DigitalLibrary.Repositories.BookRepository;

@Service
public class AdminServices {

    private final BookRepository bookRepository;

    public AdminServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // ✅ ADD BOOK (DTO → ENTITY)
    public Book addBook(BookRequestDTO dto) {

        if (dto == null) {
            throw new BadRequestException("Book data cannot be null");
        }

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setCategory(dto.getCategory());
        book.setTotalCopies(dto.getTotalCopies());
        book.setAvailableCopies(dto.getTotalCopies());

        return bookRepository.save(book);
    }

    // ✅ UPDATE BOOK
    public Book updateBook(Long bookId, BookRequestDTO dto) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + bookId));

        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setCategory(dto.getCategory());
        book.setTotalCopies(dto.getTotalCopies());

        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + bookId));
        bookRepository.delete(book);
    }
}

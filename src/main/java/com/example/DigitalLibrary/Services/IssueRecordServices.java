package com.example.DigitalLibrary.Services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.DigitalLibrary.DTOs.User.IssueBookRequestDTO;
import com.example.DigitalLibrary.DTOs.User.ReturnBookRequestDTO;
import com.example.DigitalLibrary.Entites.Book;
import com.example.DigitalLibrary.Entites.IssueRecord;
import com.example.DigitalLibrary.Entites.User;
import com.example.DigitalLibrary.ExceptionHandlers.BadRequestException;
import com.example.DigitalLibrary.ExceptionHandlers.ResourceNotFoundException;
import com.example.DigitalLibrary.Repositories.BookRepository;
import com.example.DigitalLibrary.Repositories.IssueRecordRepository;
import com.example.DigitalLibrary.Repositories.UserRepository;

@Service
public class IssueRecordServices {

    private final IssueRecordRepository issueRecordRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public IssueRecordServices(
            IssueRecordRepository issueRecordRepository,
            UserRepository userRepository,
            BookRepository bookRepository) {

        this.issueRecordRepository = issueRecordRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    // ✅ ISSUE BOOK
    public IssueRecord issueBook(IssueBookRequestDTO dto) {

        if (dto == null) {
            throw new BadRequestException("Issue request cannot be null");
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new BadRequestException("No copies available for this book");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        IssueRecord record = new IssueRecord();
        record.setUser(user);
        record.setBook(book);
        record.setIssueDate(LocalDate.now());
        record.setReturned(false);

        bookRepository.save(book);
        return issueRecordRepository.save(record);
    }

    // ✅ RETURN BOOK
    public IssueRecord returnBook(ReturnBookRequestDTO dto) {

        if (dto == null) {
            throw new BadRequestException("Return request cannot be null");
        }

        IssueRecord record = issueRecordRepository.findById(dto.getIssueId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Issue record not found"));

        if (record.isReturned()) {
            throw new BadRequestException("Book already returned");
        }

        Book book = record.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        record.setReturned(true);
        record.setReturnDate(LocalDate.now());

        bookRepository.save(book);
        return issueRecordRepository.save(record);
    }
}

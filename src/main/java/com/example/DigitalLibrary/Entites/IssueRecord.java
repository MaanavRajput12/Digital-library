package com.example.DigitalLibrary.Entites;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "issue_records")
public class IssueRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private LocalDate issueDate;
    private LocalDate returnDate;

    private boolean returned;

    public IssueRecord() {}

    public Long getIssueId() {
        return issueId;
    }

    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public Book getBook() {
        return book;
    }
 
    public void setBook(Book book) {
        this.book = book;
    }
 
    public LocalDate getIssueDate() {
        return issueDate;
    }
 
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }
 
    public LocalDate getReturnDate() {
        return returnDate;
    }
 
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }
 
    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}

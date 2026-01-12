package com.example.DigitalLibrary.DTOs.User;

import jakarta.validation.constraints.NotNull;

public class IssueBookRequestDTO {

    @NotNull
    private Long bookId;

    @NotNull
    private Long userId;

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}

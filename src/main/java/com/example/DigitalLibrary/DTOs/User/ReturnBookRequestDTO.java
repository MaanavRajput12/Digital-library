package com.example.DigitalLibrary.DTOs.User;

import jakarta.validation.constraints.NotNull;

public class ReturnBookRequestDTO {

    @NotNull
    private Long issueId;

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }
}

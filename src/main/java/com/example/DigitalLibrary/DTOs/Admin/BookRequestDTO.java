package com.example.DigitalLibrary.DTOs.Admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String category;

    @NotNull
    private Integer totalCopies;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Integer getTotalCopies() { return totalCopies; }
    public void setTotalCopies(Integer totalCopies) { this.totalCopies = totalCopies; }
}

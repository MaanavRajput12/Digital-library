package com.example.DigitalLibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DigitalLibrary.Services.BookServices;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping
    public String viewBooks(Model model) {
        model.addAttribute("books", bookServices.getAllBooks());
        return "books";
    }
}

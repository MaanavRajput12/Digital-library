package com.example.DigitalLibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DigitalLibrary.DTOs.Admin.BookRequestDTO;
import com.example.DigitalLibrary.Services.AdminServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminServices adminServices;

    public AdminController(AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/books/add")
    public String addBookPage(Model model) {
        model.addAttribute("book", new BookRequestDTO());
        return "add-book";
    }

    @PostMapping("/books")
public String addBook(
        @Valid @ModelAttribute("book") BookRequestDTO dto) {

    adminServices.addBook(dto);
    return "redirect:/admin/books";
}


    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        adminServices.deleteBook(id);
        return "redirect:/books";
    }
}

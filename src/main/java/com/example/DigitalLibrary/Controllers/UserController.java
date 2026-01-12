package com.example.DigitalLibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DigitalLibrary.DTOs.User.IssueBookRequestDTO;
import com.example.DigitalLibrary.DTOs.User.ReturnBookRequestDTO;
import com.example.DigitalLibrary.Services.IssueRecordServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final IssueRecordServices issueRecordServices;

    public UserController(IssueRecordServices issueRecordServices) {
        this.issueRecordServices = issueRecordServices;
    }

    @PostMapping("/issue")
public String issueBook(
        @Valid @ModelAttribute IssueBookRequestDTO dto) {

    issueRecordServices.issueBook(dto);
    return "redirect:/user/dashboard";
}

@PostMapping("/return")
public String returnBook(
        @Valid @ModelAttribute ReturnBookRequestDTO dto) {

    issueRecordServices.returnBook(dto);
    return "redirect:/user/dashboard";
}

}

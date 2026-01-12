package com.example.DigitalLibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DigitalLibrary.DTOs.Auth.LoginRequestDTO;
import com.example.DigitalLibrary.DTOs.Auth.RegisterUserDTO;
import com.example.DigitalLibrary.Entites.User;
import com.example.DigitalLibrary.Services.UserServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserServices userServices;

    public AuthController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequestDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginRequest") LoginRequestDTO dto,
                        Model model) {

        User user = userServices.login(dto.getEmail(), dto.getPassword());
        model.addAttribute("user", user);

        return "redirect:/books";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerRequest", new RegisterUserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(
        @Valid @ModelAttribute("registerRequest") RegisterUserDTO dto) {

    userServices.registerUser(dto);
    return "redirect:/auth/login";
}

}

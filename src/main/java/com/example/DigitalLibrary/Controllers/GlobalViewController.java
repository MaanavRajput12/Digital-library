package com.example.DigitalLibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalViewController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}

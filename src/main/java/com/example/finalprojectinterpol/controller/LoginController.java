package com.example.finalprojectinterpol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String pagForLog() {
        return "login";
    }

    @GetMapping("/error")
    public String entrancePage() {
        return "error";
    }
}

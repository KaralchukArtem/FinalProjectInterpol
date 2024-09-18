package com.example.finalprojectinterpol.controller;

import com.example.finalprojectinterpol.entities.User;
import com.example.finalprojectinterpol.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public ModelAndView viewHomePage() {
        return new ModelAndView("index");
    }

    @GetMapping("/login")
    public ModelAndView viewLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/registration")
    public ModelAndView viewRegistrationPage(Model model) {
        model.addAttribute("userForm", new User());
        return new ModelAndView("registration");
    }

    @PostMapping("/registration")
    public ModelAndView createUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration");
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return new ModelAndView("registration");
        }
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return new ModelAndView("registration");
        } else {
            userService.saveUser(userForm);
        }
        return new ModelAndView("redirect:/");
    }
}

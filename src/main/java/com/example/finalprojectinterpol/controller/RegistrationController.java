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

@Controller
public class RegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        //TODO date is always null?
        System.out.println(userForm.getDate());
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveUser(userForm)){
            System.out.println(userForm.getDate());
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }else{
            System.out.println(userForm.getDate());
            userService.saveUser(userForm);

        }
        return "redirect:/";
    }
}

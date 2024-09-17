package com.example.finalprojectinterpol.controller;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.service.StatementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StatementController {
    @Autowired
    private StatementServiceImpl service;
    @GetMapping("/statement")
    public String getSt(Model model) {
        model.addAttribute("statementForm", new StatementCreateDTO());
        return "statement";
    }
    @GetMapping("/all")
    public String getStatementList(Model model) {
        model.addAttribute("statements", service.getAllStatement());
        return "statement";
    }
    @PostMapping("/statement")
    public String createStatement(@ModelAttribute("statementForm") StatementCreateDTO statementCreateDto) {
        service.createStatement(statementCreateDto);
        return "index";
    }
}

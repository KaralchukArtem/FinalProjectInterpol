package com.example.finalprojectinterpol.controller;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementDTO;
import com.example.finalprojectinterpol.entities.Statement;
import com.example.finalprojectinterpol.service.StatementServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/statement")
public class StatementController {
    @Autowired
    private StatementServiceImpl statementService;

    @GetMapping("/create")
    public ModelAndView viewStatementPage(Model model) {
        model.addAttribute("statementForm", new StatementCreateDTO());
        return new ModelAndView("statement/statementCreate");
    }

    @PostMapping("/create")
    public ModelAndView createStatement(@ModelAttribute("statementForm") StatementCreateDTO statementCreateDto, HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        statementService.createStatement(statementCreateDto, principal);
        return new ModelAndView("index");
    }

    @GetMapping("/all")
    public ModelAndView getStatementList(Model model) {
        List<StatementDTO> statementDTOS = statementService.getAllStatement();
        System.out.println(statementDTOS.toString());
        model.addAttribute("statements", statementDTOS);
        return new ModelAndView("statement/statementViewAll");
    }

    @GetMapping("/get")
    public ModelAndView getStatementById(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Statement statement = statementService.getById(id);
            model.addAttribute("statement", statement);
        }
        return new ModelAndView("statement/statementViewNote");
    }
}

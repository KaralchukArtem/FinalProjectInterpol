package com.example.finalprojectinterpol.controller;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementUpdateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementViewDTO;
import com.example.finalprojectinterpol.entities.Statement;
import com.example.finalprojectinterpol.mapper.StatementMapper;
import com.example.finalprojectinterpol.service.StatementServiceImpl;
import com.example.finalprojectinterpol.service.UserServiceImpl;
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
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private StatementMapper statementMapper;

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
        List<StatementViewDTO> statementViewDTOS = statementService.getAllStatement();
        System.out.println(statementViewDTOS.toString());
        model.addAttribute("statements", statementViewDTOS);
        return new ModelAndView("statement/statementViewAll");
    }

    @GetMapping("/get")
    public ModelAndView getStatementById(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Statement statement = statementService.getById(id);
            StatementViewDTO statementViewDTO = statementMapper.toDTO(statement);
            model.addAttribute("statement", statementViewDTO);
        }
        return new ModelAndView("statement/statementViewNote");
    }

    @GetMapping("/update")
    public ModelAndView updateStatementById(@RequestParam(value = "id", required = false) Integer id, Model model) {
        if (id != null) {
            Statement statement = statementService.getById(id);
            StatementUpdateDTO statementUpdateDTO = statementMapper.toDTOU(statement);
            model.addAttribute("users", userService.getAllUser());
            model.addAttribute("types", statementService.getAllTypes());
            model.addAttribute("statementFormUpdate", statementUpdateDTO);
        }
        return new ModelAndView("statement/statementUpdate");
    }

    @PostMapping("/update")
    public ModelAndView updateStatementNote(@ModelAttribute("statementFormUpdate") StatementUpdateDTO statementUpdateDTO) {
        statementService.updateStatement(statementUpdateDTO);
        return new ModelAndView("index");
    }
}

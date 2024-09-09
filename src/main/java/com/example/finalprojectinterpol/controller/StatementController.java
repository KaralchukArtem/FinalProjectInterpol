package com.example.finalprojectinterpol.controller;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementDTO;
import com.example.finalprojectinterpol.service.StatementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statement")
public class StatementController {

    @Autowired
    private StatementServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<StatementDTO>> getStatementList() {
        return ResponseEntity.ok(service.getAllStatement());
    }

    @PostMapping("/create")
    public ResponseEntity<StatementDTO> createStatement(@RequestBody StatementCreateDTO statementCreateDto) {
        return ResponseEntity.ok(service.createStatement(statementCreateDto));
    }
}

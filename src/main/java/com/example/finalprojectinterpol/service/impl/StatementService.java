package com.example.finalprojectinterpol.service.impl;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementViewDTO;
import com.example.finalprojectinterpol.dto.statement.StatementUpdateDTO;
import com.example.finalprojectinterpol.entities.Statement;

import java.security.Principal;
import java.util.List;

public interface StatementService {
    List<StatementViewDTO> getAllStatement();

    StatementViewDTO createStatement(StatementCreateDTO statement, Principal userLogin);

    Statement getById(Integer name);

    StatementViewDTO updateStatement(StatementUpdateDTO statement);
}

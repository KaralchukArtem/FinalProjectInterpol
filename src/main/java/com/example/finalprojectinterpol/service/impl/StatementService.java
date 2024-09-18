package com.example.finalprojectinterpol.service.impl;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementDTO;
import com.example.finalprojectinterpol.entities.Statement;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface StatementService {
    List<StatementDTO> getAllStatement();

    StatementDTO createStatement(StatementCreateDTO statement, Principal userLogin);

    Statement getById(Integer name);

}

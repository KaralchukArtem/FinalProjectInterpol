package com.example.finalprojectinterpol.service.impl;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementDTO;

import java.util.List;

public interface StatementService {
    List<StatementDTO> getAllStatement();
    StatementDTO createStatement(StatementCreateDTO statement);

}

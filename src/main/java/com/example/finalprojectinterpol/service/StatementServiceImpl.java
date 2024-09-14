package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementDTO;
import com.example.finalprojectinterpol.entities.Statement;
import com.example.finalprojectinterpol.mapper.StatementMapper;
import com.example.finalprojectinterpol.repository.StatementRepository;
import com.example.finalprojectinterpol.service.impl.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementServiceImpl implements StatementService {
    @Autowired
    private StatementRepository statementRepository;

    private final StatementMapper statementMapper;

    @Override
    public List<StatementDTO> getAllStatement() {
        List<Statement> statementList = statementRepository.findAll();
        List<StatementDTO> statementDtoList = statementMapper.toDTOList(statementList);
        return statementDtoList;
    }

    //TODO
    /*
    *   Take from the User session when creating a statement and add it.
    *   ( Брать из сессии Юзера, при создании заявления, добавлять его )
    */
    @Override
    public StatementDTO createStatement(StatementCreateDTO statementCreateDto) {
        Statement statement = statementMapper.toEntity(statementCreateDto);
        Statement saveStatement = statementRepository.save(statement);
        StatementDTO statementDto = statementMapper.toDTO(saveStatement);
        return statementDto;
    }
}

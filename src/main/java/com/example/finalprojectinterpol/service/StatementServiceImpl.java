package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementDTO;
import com.example.finalprojectinterpol.entities.Statement;
import com.example.finalprojectinterpol.mapper.StatementMapper;
import com.example.finalprojectinterpol.repository.StatementRepository;
import com.example.finalprojectinterpol.repository.StatementTypeRepository;
import com.example.finalprojectinterpol.repository.UserRepository;
import com.example.finalprojectinterpol.service.impl.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class StatementServiceImpl implements StatementService {
    @Autowired
    private StatementRepository statementRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StatementTypeRepository typeRepository;
    @Autowired
    private StatementMapper statementMapper;

    @Override
    public List<StatementDTO> getAllStatement() {
        List<Statement> statementList = statementRepository.findAll();
        List<StatementDTO> statementDtoList = statementMapper.toDTOList(statementList);
        return statementDtoList;
    }

    @Override
    public StatementDTO createStatement(StatementCreateDTO statementCreateDto, Principal userLogin) {
        Statement statement = statementMapper.toEntity(statementCreateDto);
        statement.setUser_id(userRepository.findByLogin(userLogin.getName()));
        statement.setType_id(typeRepository.findByName("missing"));
        Statement saveStatement = statementRepository.save(statement);
        StatementDTO statementDto = statementMapper.toDTO(saveStatement);
        return statementDto;
    }

    @Override
    public Statement getById(Integer id) {
        return statementRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unexpected statement id!"));
    }
}

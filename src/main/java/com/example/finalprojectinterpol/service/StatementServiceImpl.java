package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementUpdateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementViewDTO;
import com.example.finalprojectinterpol.entities.Statement;
import com.example.finalprojectinterpol.entities.TypeStatement;
import com.example.finalprojectinterpol.mapper.StatementMapper;
import com.example.finalprojectinterpol.repository.StatementRepository;
import com.example.finalprojectinterpol.repository.StatementTypeRepository;
import com.example.finalprojectinterpol.repository.UserRepository;
import com.example.finalprojectinterpol.service.impl.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

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

    public List<TypeStatement> getAllTypes() {
        List<TypeStatement> typeStatements = typeRepository.findAll();
        return typeStatements;
    }

    @Override
    public List<StatementViewDTO> getAllStatement() {
        List<Statement> statementList = statementRepository.findAll();
        List<StatementViewDTO> statementViewDtoList = statementMapper.toDTOList(statementList);
        return statementViewDtoList;
    }

    @Override
    public StatementViewDTO createStatement(StatementCreateDTO statementCreateDto, Principal userLogin) {
        Statement statement = statementMapper.toEntity(statementCreateDto);
        statement.setUser_id(userRepository.findByLogin(userLogin.getName()));
        statement.setType_id(typeRepository.findByName("missing"));
        Statement saveStatement = statementRepository.save(statement);
        StatementViewDTO statementViewDto = statementMapper.toDTO(saveStatement);
        return statementViewDto;
    }

    @Override
    public Statement getById(Integer id) {
        return statementRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Unexpected statement id!"));
    }

    @Override
    public StatementViewDTO updateStatement(StatementUpdateDTO statementUpdateDTO) {
        Statement statement = statementMapper.toEntity(statementUpdateDTO);
        Statement saveStatement = statementRepository.save(statement);
        StatementViewDTO statementViewDto = statementMapper.toDTO(saveStatement);
        return statementViewDto;
    }
    //TODO delete
}

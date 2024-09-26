package com.example.finalprojectinterpol.mapper;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementViewDTO;
import com.example.finalprojectinterpol.dto.statement.StatementUpdateDTO;
import com.example.finalprojectinterpol.entities.Statement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface StatementMapper {
    StatementViewDTO toDTO(Statement statement);
    StatementUpdateDTO toDTOU(Statement statement);

    Statement toEntity(StatementCreateDTO statement);

    Statement toEntity(StatementUpdateDTO statement);

    List<StatementViewDTO> toDTOList(List<Statement> statements);
}

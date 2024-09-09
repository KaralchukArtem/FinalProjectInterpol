package com.example.finalprojectinterpol.mapper;

import com.example.finalprojectinterpol.dto.statement.StatementCreateDTO;
import com.example.finalprojectinterpol.dto.statement.StatementDTO;
import com.example.finalprojectinterpol.entities.Statement;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface StatementMapper {
    StatementDTO toDTO(Statement statement);

    Statement toEntity(StatementCreateDTO statement);

    List<StatementDTO> toDTOList(List<Statement> statements);
}

package com.example.finalprojectinterpol.repository;

import com.example.finalprojectinterpol.entities.TypeStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementTypeRepository extends JpaRepository<TypeStatement, Integer> {
    TypeStatement findByName(String name);
}

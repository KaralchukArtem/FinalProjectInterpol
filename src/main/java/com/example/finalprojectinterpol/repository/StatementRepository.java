package com.example.finalprojectinterpol.repository;

import com.example.finalprojectinterpol.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatementRepository extends JpaRepository<Statement,Integer> {
    Optional<Statement> findById(Integer id);
}

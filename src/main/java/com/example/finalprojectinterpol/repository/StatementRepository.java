package com.example.finalprojectinterpol.repository;

import com.example.finalprojectinterpol.entities.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement,Integer> {
}

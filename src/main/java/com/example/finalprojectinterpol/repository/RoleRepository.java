package com.example.finalprojectinterpol.repository;

import com.example.finalprojectinterpol.entities.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleUser, Integer> {
    RoleUser findByName(String name);
}

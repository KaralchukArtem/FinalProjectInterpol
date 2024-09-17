package com.example.finalprojectinterpol.repository;

import com.example.finalprojectinterpol.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLogin(String username);

    User findByName(String username);
}

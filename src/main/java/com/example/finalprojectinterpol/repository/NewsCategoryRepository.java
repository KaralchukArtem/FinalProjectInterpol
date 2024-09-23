package com.example.finalprojectinterpol.repository;

import com.example.finalprojectinterpol.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsCategoryRepository extends JpaRepository<Category,Integer> {
    Category findByType(String news);
}

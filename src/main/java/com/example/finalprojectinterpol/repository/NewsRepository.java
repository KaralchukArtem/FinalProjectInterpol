package com.example.finalprojectinterpol.repository;

import com.example.finalprojectinterpol.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> {
}

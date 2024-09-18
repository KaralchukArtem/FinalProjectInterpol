package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.repository.NewsCategoryRepository;
import com.example.finalprojectinterpol.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsCategoryRepository newsCategoryRepository;


}

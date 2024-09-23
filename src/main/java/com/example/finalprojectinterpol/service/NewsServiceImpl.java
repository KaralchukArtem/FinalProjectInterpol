package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.dto.news.NewsCreateDTO;
import com.example.finalprojectinterpol.dto.news.NewsDTO;
import com.example.finalprojectinterpol.entities.News;
import com.example.finalprojectinterpol.mapper.NewsMapper;
import com.example.finalprojectinterpol.repository.NewsCategoryRepository;
import com.example.finalprojectinterpol.repository.NewsRepository;
import com.example.finalprojectinterpol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Service
public class NewsServiceImpl {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsCategoryRepository newsCategoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewsMapper newsMapper;
    private final String directory = "/resources/images";
    public List<NewsDTO> getAllNews(){
        List<News> news = newsRepository.findAll();
        List<NewsDTO> newsDTOList = newsMapper.toDTOList(news);
        return newsDTOList;
    }
    public NewsDTO createNews(NewsCreateDTO newsCreateDTO, Principal userLogin, MultipartFile multipartFile) throws IOException {
        String path = String.valueOf(Files.copy(multipartFile.getInputStream(), Paths.get(directory).resolve(multipartFile.getOriginalFilename())));
        System.out.println("newsCreateDTO - \n" + newsCreateDTO);
        News news = newsMapper.toEntity(newsCreateDTO);
        news.setImageData(path);
        news.setUserModel(userRepository.findByLogin(userLogin.getName()));
        news.setCategory_id(newsCategoryRepository.findByType("news"));
        System.out.println("newsDTO - \n" + news);
        News newsSave = newsRepository.save(news);
        NewsDTO newsDTO = newsMapper.toDTO(newsSave);
        return newsDTO;
    }
    //TODO
    /*
    * delete, update
    */
}

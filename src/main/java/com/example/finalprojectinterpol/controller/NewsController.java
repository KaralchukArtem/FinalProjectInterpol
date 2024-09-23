package com.example.finalprojectinterpol.controller;

import com.example.finalprojectinterpol.dto.news.NewsCreateDTO;
import com.example.finalprojectinterpol.dto.news.NewsDTO;
import com.example.finalprojectinterpol.entities.News;
import com.example.finalprojectinterpol.mapper.NewsMapper;
import com.example.finalprojectinterpol.repository.NewsCategoryRepository;
import com.example.finalprojectinterpol.repository.NewsRepository;
import com.example.finalprojectinterpol.repository.UserRepository;
import com.example.finalprojectinterpol.service.NewsServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsCategoryRepository newsCategoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewsMapper newsMapper;
    private final String directory = "src/main/resources/static/images";

    @GetMapping("/all")
    public ModelAndView getNewsList(Model model) {
        List<NewsDTO> newsDTOS = newsService.getAllNews();
        System.out.println(newsDTOS.toString());
        model.addAttribute("newsDTOS", newsDTOS);
        return new ModelAndView("news/newsViewAll");
    }
    @GetMapping("/create")
    public ModelAndView viewNewsPage(Model model) {
        model.addAttribute("newsForm", new NewsCreateDTO());
        return new ModelAndView("news/newsCreate");
    }
    @PostMapping("/create")
    public ModelAndView createNews(
            @RequestParam(value = "imageData", required = false) MultipartFile multipartFile,
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "text", required = false) String text,
            HttpServletRequest request) throws IOException {
        Principal principal = request.getUserPrincipal();
        NewsCreateDTO newsCreateDTO = new NewsCreateDTO();
        newsCreateDTO.setTitle(title);
        newsCreateDTO.setText(text);
        newsCreateDTO.setYear(LocalDate.now());

        Files.copy(multipartFile.getInputStream(), Paths.get(directory).resolve(multipartFile.getOriginalFilename()));
        System.out.println("newsCreateDTO - \n" + newsCreateDTO);

        News news = newsMapper.toEntity(newsCreateDTO);
        news.setImageData(multipartFile.getOriginalFilename());
        news.setUserModel(userRepository.findByLogin(principal.getName()));
        news.setCategory_id(newsCategoryRepository.findByType("news"));

        System.out.println("newsDTO - \n" + news);
        newsRepository.save(news);
//        newsService.createNews(newsCreateDTO,principal,multipartFile);
        return new ModelAndView("index");
    }
    @GetMapping("/get")
    public ModelAndView getStatementById(@RequestParam(value = "id", required = false) Integer id, Model model) throws IOException {
        if (id != null) {
            News news = newsRepository.findById(id).orElseThrow();
            NewsDTO newsDTO = newsMapper.toDTO(news);
            System.out.println("newsDTO" + newsDTO.getImageData());
            Path file = Paths.get(directory).resolve(newsDTO.getImageData());
            Resource resource = new UrlResource(file.toUri());
            System.out.println("resours = " + resource+"\n" + "file = " + file.toUri());
            news.setImageData(file.toString());
            model.addAttribute("file",resource);
            model.addAttribute("news", news);
        }
        return new ModelAndView("news/newsViewNote");
    }
}

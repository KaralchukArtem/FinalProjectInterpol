package com.example.finalprojectinterpol.dto.news;

import com.example.finalprojectinterpol.entities.Category;
import com.example.finalprojectinterpol.entities.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NewsDTO {
    private int id;
    private String title;
    private String imageData;
    private String text;
    private LocalDate year;
    private Category category_id;
}

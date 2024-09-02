package com.example.finalprojectinterpol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "news")
public class NewsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "img")
    private String img;
    @Column(name = "text")
    private String text;
    @Column(name = "type")
    private String type;
    @Column(name = "year")
    private Date year;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;
}

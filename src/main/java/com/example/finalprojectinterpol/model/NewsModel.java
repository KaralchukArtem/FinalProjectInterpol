package com.example.finalprojectinterpol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}

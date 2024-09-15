package com.example.finalprojectinterpol.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class News {
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
    private LocalDate year;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userModel;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;
}

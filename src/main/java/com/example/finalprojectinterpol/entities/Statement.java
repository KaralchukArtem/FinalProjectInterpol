package com.example.finalprojectinterpol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "statement")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;
    @Column(name = "place_of_birth")
    private String place_of_birth;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private int weight;
    @Column(name = "eye_color")
    private String eye_color;
    @Column(name = "accusation")
    private String accusation;
    @Column(name = "reward")
    private int reward;
    @Column(name = "physique")
    private String physique;
    @Column(name = "approved")
    private boolean approved;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeStatement type_id;
}

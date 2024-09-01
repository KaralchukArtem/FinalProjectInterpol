package com.example.finalprojectinterpol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "statement")
public class StatementModel {
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
    private Date date_of_birth;
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
    private UserModel userModel;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeStatementModel typeStatementModel;
}

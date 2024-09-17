package com.example.finalprojectinterpol.dto.statement;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StatementDTO {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private LocalDate date_of_birth;
    private String place_of_birth;
    private String nationality;
    private int height;
    private int weight;
    private String eye_color;
    private String accusation;
    private int reward;
    private String physique;
    private boolean approved;
}

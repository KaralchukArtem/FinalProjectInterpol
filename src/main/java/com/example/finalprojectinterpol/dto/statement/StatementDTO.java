package com.example.finalprojectinterpol.dto.statement;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementDTO {
    private int id;
    private String name;
    private String surname;
    private String gender;
    private Date date_of_birth;
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

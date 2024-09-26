package com.example.finalprojectinterpol.dto.statement;

import com.example.finalprojectinterpol.entities.TypeStatement;
import com.example.finalprojectinterpol.entities.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class StatementUpdateDTO {
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
    private User user_id;
    private TypeStatement type_id;
}

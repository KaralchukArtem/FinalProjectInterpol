package com.example.finalprojectinterpol.dto.statement;

import com.example.finalprojectinterpol.entities.TypeStatement;
import com.example.finalprojectinterpol.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatementCreateDTO {
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

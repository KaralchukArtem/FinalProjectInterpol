package com.example.finalprojectinterpol.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Transient
    private String passwordConfirm;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_birth")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleUser role_id;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }
}

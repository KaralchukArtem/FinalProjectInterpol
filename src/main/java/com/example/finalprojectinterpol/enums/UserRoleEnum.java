package com.example.finalprojectinterpol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRoleEnum {

    ROLE_ADMIN(1, "ROLE_ADMIN"), ROLE_USER(2, "ROLE_USER");

    private int id;
    private String roleName;

    public static UserRoleEnum defaultRole() {
        return ROLE_ADMIN;
    }
}

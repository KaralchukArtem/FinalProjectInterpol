package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.entities.RoleUser;
import com.example.finalprojectinterpol.enums.UserRoleEnum;
import com.example.finalprojectinterpol.repository.RoleRepository;
import com.example.finalprojectinterpol.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public RoleUser getDefaultRole() {
        return roleRepository.findById(UserRoleEnum.defaultRole().getId())
                .orElseThrow(() -> new IllegalArgumentException("Unexpected role id!"));
    }
}

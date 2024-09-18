package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.repository.RoleRepository;
import com.example.finalprojectinterpol.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
}

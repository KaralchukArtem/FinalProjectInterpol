package com.example.finalprojectinterpol.service;

import com.example.finalprojectinterpol.entities.User;
import com.example.finalprojectinterpol.repository.RoleRepository;
import com.example.finalprojectinterpol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user != null) {
            Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
            grantedAuthoritySet.add(new SimpleGrantedAuthority(user.getRole_id().getName()));
            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthoritySet);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public boolean saveUser(User user) {
        System.out.println("Save");
        User userFromDB = userRepository.findByLogin(user.getLogin());
        if (userFromDB != null) {
            return false;
        }
        user.setRole_id(roleRepository.findByName("ROLE_USER"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println(user.getDate());
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}

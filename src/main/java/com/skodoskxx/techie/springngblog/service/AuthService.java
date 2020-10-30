package com.skodoskxx.techie.springngblog.service;

import com.skodoskxx.techie.springngblog.dto.RegisterRequest;
import com.skodoskxx.techie.springngblog.model.User;
import com.skodoskxx.techie.springngblog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(encodePassword(registerRequest.getPassword()));
        user.setEmail(registerRequest.getEmail());
        userRepo.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}

package com.skodoskxx.techie.springngblog.service;

import com.skodoskxx.techie.springngblog.dto.RegisterRequest;
import com.skodoskxx.techie.springngblog.model.User;
import com.skodoskxx.techie.springngblog.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        userRepo.save(user);
    }
}

package com.skodoskxx.techie.springngblog.controller;

import com.skodoskxx.techie.springngblog.dto.RegisterRequest;
import com.skodoskxx.techie.springngblog.service.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(RegisterRequest registerRequest){
    authService.signup(registerRequest);
    return new ResponseEntity(HttpStatus.OK);
    }
}

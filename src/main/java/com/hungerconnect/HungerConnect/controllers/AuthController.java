package com.hungerconnect.HungerConnect.controllers;

import com.hungerconnect.HungerConnect.dto.LoginRequest;
import com.hungerconnect.HungerConnect.dto.RegisterRequest;
import com.hungerconnect.HungerConnect.dto.RegisterResponse;
import com.hungerconnect.HungerConnect.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        return authService.registerUser(registerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated= authService.loginUser(loginRequest);
        if(isAuthenticated){
            return ResponseEntity.ok("Login Successful!");
        }
        else return ResponseEntity.status(401).body("Invalid Credentials");
    }
}

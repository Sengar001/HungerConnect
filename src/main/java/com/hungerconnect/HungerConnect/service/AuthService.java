package com.hungerconnect.HungerConnect.service;

import com.hungerconnect.HungerConnect.dto.LoginRequest;
import com.hungerconnect.HungerConnect.dto.RegisterRequest;
import com.hungerconnect.HungerConnect.dto.RegisterResponse;
import com.hungerconnect.HungerConnect.models.User;
import com.hungerconnect.HungerConnect.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    public ResponseEntity<RegisterResponse> registerUser(RegisterRequest registerRequest) {
        if(userRepo.findByEmail(registerRequest.getEmail()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new RegisterResponse("Email already in use", null));
        }
        User user=new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setPhone(registerRequest.getPhone());
        user.setAddress(registerRequest.getAddress());
        user.setRole(registerRequest.getRole());
//        System.out.println(registerRequest.getRole());
        User savedUser =userRepo.save(user);
        return ResponseEntity.ok(new RegisterResponse("User registered successfully", savedUser.getId()));
    }

    public boolean loginUser(LoginRequest loginRequest) {
        User user=userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(()->new RuntimeException("User not found"));
        return passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
    }
}

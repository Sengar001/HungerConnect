package com.hungerconnect.HungerConnect.controllers;

import com.hungerconnect.HungerConnect.dto.UserRequest;
import com.hungerconnect.HungerConnect.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("user") String user, @RequestParam ("password") String password) {
        return ResponseEntity.ok(authService.login(user, password));
    }
}

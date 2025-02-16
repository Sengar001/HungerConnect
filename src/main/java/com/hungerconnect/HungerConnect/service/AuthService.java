package com.hungerconnect.HungerConnect.service;

import com.hungerconnect.HungerConnect.dto.UserRequest;
import com.hungerconnect.HungerConnect.entity.Users;
import com.hungerconnect.HungerConnect.loginhelper.EncryptionService;
import com.hungerconnect.HungerConnect.loginhelper.JWThelper;
import com.hungerconnect.HungerConnect.mapper.UserMaper;
import com.hungerconnect.HungerConnect.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    private final EncryptionService encryptionService;
    private final JWThelper jwThelper;
    private final UserMaper userMaper;

    public String createUser(UserRequest userRequest) {
        Users newUser = userMaper.toEntity(userRequest);
        userRepo.save(newUser);
        return "User created";
    }

    public Users retrieveUser(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException((format("User with email %s not found", email))));
    }

    public String login(String username, String password) {
        Users user = retrieveUser(username);
        if(!encryptionService.validates(password, user.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }

        return jwThelper.generateToken(username);
    }
}

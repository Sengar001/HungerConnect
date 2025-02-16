package com.hungerconnect.HungerConnect.mapper;

import com.hungerconnect.HungerConnect.dto.UserRequest;
import com.hungerconnect.HungerConnect.dto.UserResponse;
import com.hungerconnect.HungerConnect.entity.Users;
import com.hungerconnect.HungerConnect.loginhelper.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMaper {
    private final EncryptionService encryptionService;

    public Users toEntity(UserRequest request) {
        return Users.builder()
                .firstName(request.name())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .password(encryptionService.encode(request.password()))
                .role(request.role())
                .build();
    }

//    public UserResponse userResponse(Users users) {
//        return new UserResponse(users.getUserId(), users.getFirstName(), users.getLastName(), users.getEmail(), users.getPassword());
//    }
}

package com.hungerconnect.HungerConnect.mapper;

import com.hungerconnect.HungerConnect.dto.UserResponse;
import com.hungerconnect.HungerConnect.entity.Users;
import org.springframework.stereotype.Service;

@Service
public class UserMaper {
    public UserResponse userResponse(Users users) {
        return new UserResponse(users.getUserId(), users.getFirstName(), users.getLastName(), users.getEmail(), users.getPassword());
    }
}

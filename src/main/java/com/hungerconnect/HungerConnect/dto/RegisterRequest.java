package com.hungerconnect.HungerConnect.dto;

import com.hungerconnect.HungerConnect.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;
    private Role role;
}

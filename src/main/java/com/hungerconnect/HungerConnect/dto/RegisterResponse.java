package com.hungerconnect.HungerConnect.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    String message;
    Long userId;
}

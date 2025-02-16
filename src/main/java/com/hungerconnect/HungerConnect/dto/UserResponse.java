package com.hungerconnect.HungerConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserResponse(
        @JsonProperty("user_id")
        Long id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("phone")
        Long phone,
        @JsonProperty("email")
        String email,
        @JsonProperty("role")
        String role
) {
}

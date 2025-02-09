package com.hungerconnect.HungerConnect.models;

import com.hungerconnect.HungerConnect.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

//@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;
}

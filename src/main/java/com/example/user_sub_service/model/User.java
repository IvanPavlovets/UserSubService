package com.example.user_sub_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "'name' must be unique and not empty")
    private String name;
    @NotBlank(message = "'password' must be not empty")
    private String password;
    @NotBlank(message = "'email' must be unique and not empty")
    private String email;
}

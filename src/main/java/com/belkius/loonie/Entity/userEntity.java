package com.belkius.loonie.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class userEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @Size(min = 8)
    private String password;

    @Past(message = "The date of birth must be in the past")
    private LocalDate birthDate;

    @PositiveOrZero
    private int failedAttempts = 0;

    private Boolean isLocked;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER, ADMIN;
    };
}
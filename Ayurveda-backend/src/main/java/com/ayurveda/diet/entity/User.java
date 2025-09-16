// FileName: src/main/java/com/ayurveda/diet/entity/User.java
package com.ayurveda.diet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // <-- FIX 1: Added UUID generation
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    // --- FIX 2: Added mapping to the correct 'password_hash' column ---
    @Column(name = "password_hash", nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // doctor | patient | admin

    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime createdAt;
}
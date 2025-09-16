package com.ayurveda.diet.dto;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private UUID userId;
    private String fullName;
    private String email;
    private String role;  // doctor | patient | admin
    private OffsetDateTime createdAt;
}

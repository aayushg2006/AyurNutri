package com.ayurveda.diet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private boolean success;
    private String message;
    private String role;
    private String userId;
}

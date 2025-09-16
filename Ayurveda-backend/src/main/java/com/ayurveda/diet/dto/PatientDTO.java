// FileName: src/main/java/com/ayurveda/diet/dto/PatientDTO.java
package com.ayurveda.diet.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List; // This import is no longer used, but fine
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    private UUID patientId;
    private String gender;
    private LocalDate dateOfBirth;
    private String prakritiType;
    private String digestivePower;
    private String bowelMovement;
    private Integer mealFrequency;
    private Double waterIntakeLtr;

    // --- THIS IS THE FIX ---
    // Changed from List<String> to String to match the Entity and DB
    private String allergies;
    // --- END FIX ---

    private String notes;
}
// FileName: src/main/java/com/ayurveda/diet/dto/PatientDailyLogDTO.java
package com.ayurveda.diet.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class PatientDailyLogDTO {
    private UUID id;
    private UUID patientId;
    private LocalDate logDate;
    private Double waterIntakeMl;
    private String breakfastStatus;
    private String midMorningStatus;
    private String lunchStatus;
    private String afternoonStatus;
    private String dinnerStatus;
    private String bedtimeStatus;
    private String mealNotes;
}
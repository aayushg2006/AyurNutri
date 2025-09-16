// FileName: src/main/java/com/ayurveda/diet/entity/PatientDailyLog.java
package com.ayurveda.diet.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "patient_daily_log")
@Data
public class PatientDailyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "patient_id")
    private UUID patientId;

    @Column(name = "log_date")
    private LocalDate logDate;

    @Column(name = "water_intake_ml", columnDefinition = "numeric")
    private Double waterIntakeMl;

    private String breakfastStatus;
    private String midMorningStatus;
    private String lunchStatus;
    private String afternoonStatus;
    private String dinnerStatus;
    private String bedtimeStatus;

    private String mealNotes;
}
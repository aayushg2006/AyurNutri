// FileName: src/main/java/com/ayurveda/diet/entity/Patient.java
package com.ayurveda.diet.entity;

// --- We no longer need the hypersistence imports ---
// import org.hibernate.annotations.Type;
// import io.hypersistence.utils.hibernate.type.array.ListArrayType;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List; // This import is no longer used, but fine to leave
import java.util.UUID;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @Column(name = "patient_id")
    private UUID patientId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "patient_id")
    private User user;

    private String gender;
    private LocalDate dateOfBirth;
    private String prakritiType;
    private String digestivePower;
    private String bowelMovement;
    private Integer mealFrequency;

    @Column(name = "water_intake_ltr", columnDefinition = "numeric")
    private Double waterIntakeLtr;

    // --- THIS IS THE FIX ---
    // Changed from List<String> to a simple String to match your new "text" schema.
    // All annotations for the array are removed.
    @Column(name = "allergies")
    private String allergies;
    // --- END FIX ---

    private String notes;
}
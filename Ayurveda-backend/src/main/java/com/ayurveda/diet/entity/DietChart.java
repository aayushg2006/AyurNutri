package com.ayurveda.diet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "diet_charts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietChart {
    @Id
    @GeneratedValue
    @Column(name = "chart_id", updatable = false, nullable = false)
    private UUID chartId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private User doctor;

    private OffsetDateTime createdAt;
    private String goal;
    private String notes;

    // Add this line to both DietChart.java and DietChartDTO.java
    private String pdfUrl;
}

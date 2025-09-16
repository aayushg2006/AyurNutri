package com.ayurveda.diet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue
    @Column(name = "feedback_id", updatable = false, nullable = false)
    private UUID feedbackId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "chart_id")
    private DietChart chart;

    private Integer rating;
    private String comment;

    private OffsetDateTime createdAt;
}

package com.ayurveda.diet.dto;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDTO {
    private UUID feedbackId;
    private UUID patientId;
    private UUID chartId;
    private Integer rating;
    private String comment;
    private OffsetDateTime createdAt;
}

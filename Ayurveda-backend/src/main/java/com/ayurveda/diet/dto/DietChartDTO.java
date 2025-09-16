package com.ayurveda.diet.dto;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietChartDTO {
    private UUID chartId;
    private UUID patientId;
    private UUID doctorId;
    private OffsetDateTime createdAt;
    private String goal;
    private String notes;
    // Add this line to both DietChart.java and DietChartDTO.java
    private String pdfUrl;
}

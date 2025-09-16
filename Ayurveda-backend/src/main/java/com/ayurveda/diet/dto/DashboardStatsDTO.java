// FileName: src/main/java/com/ayurveda/diet/dto/DashboardStatsDTO.java
package com.ayurveda.diet.dto;

import lombok.Data;
import java.util.Map;

@Data
public class DashboardStatsDTO {
    private long activePatientCount;
    private long dietChartsCreatedCount;
    private Map<String, Long> doshaDistribution; // e.g., {"Pitta-Kapha": 10, "Vata": 5}
}
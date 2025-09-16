// FileName: src/main/java/com/ayurveda/diet/dto/AnalysisReportDTO.java
package com.ayurveda.diet.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class AnalysisReportDTO {
    private double totalCalories;
    private double totalProtein;
    private double totalFat;
    private double totalCarbs;

    // We'll use a Map to count the properties
    // e.g., {"Hot": 2, "Cold": 1}
    private Map<String, Integer> viryaCount;

    // e.g., {"Sweet": 2, "Pungent": 1}
    private Map<String, Integer> rasaCount;

    // e.g., {"Heavy": 1, "Light": 2}
    private Map<String, Integer> gunaCount;
}
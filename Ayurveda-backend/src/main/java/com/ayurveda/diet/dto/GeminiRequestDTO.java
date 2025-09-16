// FileName: src/main/java/com/ayurveda/diet/dto/GeminiRequestDTO.java
package com.ayurveda.diet.dto;

import lombok.Data;

// @Data from Lombok gives you all the getters, setters, and constructors you need.
@Data
public class GeminiRequestDTO {
    private String patientCondition;
    private String mealRequest;
}
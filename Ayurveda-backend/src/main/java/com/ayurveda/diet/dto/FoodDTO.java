package com.ayurveda.diet.dto;

import lombok.*;
import java.util.UUID;
import com.fasterxml.jackson.databind.JsonNode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDTO {
    private UUID foodId;
    private String name;
    private String category;
    private Double caloriesPer100g;
    private Double proteinG;
    private Double fatG;
    private Double carbsG;
    private JsonNode ayurvedaProps;
    private Boolean isSeasonal;
}

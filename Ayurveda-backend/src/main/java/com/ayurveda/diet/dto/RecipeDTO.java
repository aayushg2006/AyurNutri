package com.ayurveda.diet.dto;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDTO {
    private UUID recipeId;
    private String name;
    private String description;
    private String ayurvedaNotes;
    private UUID creatorId;
}

package com.ayurveda.diet.dto;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeIngredientDTO {

    private UUID recipeId;
    private UUID foodId;
    private Double quantityG;
    private String unit;
}

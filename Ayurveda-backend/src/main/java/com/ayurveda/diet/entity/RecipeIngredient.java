// FileName: src/main/java/com/ayurveda/diet/entity/RecipeIngredient.java
package com.ayurveda.diet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "recipe_ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient {

    @Id
    @Column(name = "recipe_id")
    private UUID recipeId;

    @Id
    @Column(name = "food_id")
    private UUID foodId;

    // --- THIS IS THE FIX ---
    @Column(name = "quantity_g", columnDefinition = "numeric")
    private Double quantityG;

    private String unit;
}
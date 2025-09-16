package com.ayurveda.diet.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RecipeIngredientId implements Serializable {
    private UUID recipeId;
    private UUID foodId;
}

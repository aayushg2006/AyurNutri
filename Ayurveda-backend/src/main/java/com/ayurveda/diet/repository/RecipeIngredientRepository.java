package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.RecipeIngredient;
import com.ayurveda.diet.entity.RecipeIngredientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, RecipeIngredientId> {
    // Find all ingredients for a recipe
    List<RecipeIngredient> findByRecipeId(UUID recipeId);

    // Optional: find by foodId
    List<RecipeIngredient> findByFoodId(UUID foodId);
}

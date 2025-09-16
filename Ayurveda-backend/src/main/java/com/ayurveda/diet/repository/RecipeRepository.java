package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.Recipe;
import com.ayurveda.diet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
    List<Recipe> findByCreator(User creator);
    List<Recipe> findByNameContainingIgnoreCase(String nameFragment);
}

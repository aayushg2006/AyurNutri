package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {
    List<Food> findByNameContainingIgnoreCase(String nameFragment);
    List<Food> findByCategory(String category);
    List<Food> findByIsSeasonalTrue();
}

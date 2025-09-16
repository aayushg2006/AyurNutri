package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.RecipeIngredientDTO;
import com.ayurveda.diet.service.RecipeIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipe-ingredients")
@RequiredArgsConstructor
public class RecipeIngredientController {

    private final RecipeIngredientService service;

    @PostMapping
    public RecipeIngredientDTO create(@RequestBody RecipeIngredientDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<RecipeIngredientDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{recipeId}/{foodId}")
    public RecipeIngredientDTO getById(@PathVariable UUID recipeId, @PathVariable UUID foodId) {
        return service.getById(recipeId, foodId);
    }

    @DeleteMapping("/{recipeId}/{foodId}")
    public void delete(@PathVariable UUID recipeId, @PathVariable UUID foodId) {
        service.delete(recipeId, foodId);
    }
}

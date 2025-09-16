package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.RecipeIngredientDTO;
import com.ayurveda.diet.entity.RecipeIngredientId;
import com.ayurveda.diet.mapper.RecipeIngredientMapper;
import com.ayurveda.diet.repository.RecipeIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeIngredientService {

    private final RecipeIngredientRepository repository;
    private final RecipeIngredientMapper mapper;

    // ✅ Create a new recipe ingredient
    public RecipeIngredientDTO create(RecipeIngredientDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    // ✅ Fetch all recipe ingredients
    public List<RecipeIngredientDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    // ✅ Fetch a single recipe ingredient by composite key
    public RecipeIngredientDTO getById(UUID recipeId, UUID foodId) {
        return repository.findById(new RecipeIngredientId(recipeId, foodId))
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    // ✅ Delete a recipe ingredient by composite key
    public void delete(UUID recipeId, UUID foodId) {
        repository.deleteById(new RecipeIngredientId(recipeId, foodId));
    }
}

package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.RecipeDTO;
import com.ayurveda.diet.entity.Recipe;
import com.ayurveda.diet.mapper.RecipeMapper;
import com.ayurveda.diet.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository repository;
    private final RecipeMapper mapper;

    public RecipeDTO create(RecipeDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<RecipeDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public RecipeDTO getById(UUID id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

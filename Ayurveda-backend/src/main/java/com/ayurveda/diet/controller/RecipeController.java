package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.RecipeDTO;
import com.ayurveda.diet.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService service;

    @PostMapping
    public RecipeDTO create(@RequestBody RecipeDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<RecipeDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RecipeDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

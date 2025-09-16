package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.FoodDTO;
import com.ayurveda.diet.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService service;

    @PostMapping
    public FoodDTO create(@RequestBody FoodDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<FoodDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FoodDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

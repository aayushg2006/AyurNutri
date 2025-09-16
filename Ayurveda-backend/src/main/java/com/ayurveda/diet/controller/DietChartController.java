package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.DietChartDTO;
import com.ayurveda.diet.service.DietChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/diet-charts")
@RequiredArgsConstructor
public class DietChartController {

    private final DietChartService service;

    @PostMapping
    public DietChartDTO create(@RequestBody DietChartDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<DietChartDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DietChartDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

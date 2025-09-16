// FileName: src/main/java/com/ayurveda/diet/controller/DietChartItemController.java
package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.DietChartItemDTO;
import com.ayurveda.diet.service.DietChartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/diet-chart-items")
@RequiredArgsConstructor
public class DietChartItemController {

    private final DietChartItemService service;

    @PostMapping
    public DietChartItemDTO create(@RequestBody DietChartItemDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<DietChartItemDTO> getAll() {
        return service.getAll();
    }

    // FIX: Changed delete to use @PathVariables (much better REST design)
    @DeleteMapping("/{chartId}/{mealTime}/{itemId}")
    public void delete(
            @PathVariable UUID chartId,
            @PathVariable String mealTime,
            @PathVariable UUID itemId) {
        
        service.deleteByCompositeKey(chartId, mealTime, itemId);
    }
}
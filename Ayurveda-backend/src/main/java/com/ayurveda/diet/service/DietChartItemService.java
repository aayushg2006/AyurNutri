// FileName: src/main/java/com/ayurveda/diet/service/DietChartItemService.java
package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.DietChartItemDTO;
import com.ayurveda.diet.entity.DietChartItem;
import com.ayurveda.diet.entity.DietChartItemPK; // Use the new PK class
import com.ayurveda.diet.mapper.DietChartItemMapper;
import com.ayurveda.diet.repository.DietChartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DietChartItemService {

    private final DietChartItemRepository repository;
    private final DietChartItemMapper mapper;

    public DietChartItemDTO create(DietChartItemDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<DietChartItemDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    // FIX: Update delete method to accept the new PK
    public void delete(DietChartItemPK id) {
        repository.deleteById(id);
    }
    
    // You can also add a helper delete method
    public void deleteByCompositeKey(UUID chartId, String mealTime, UUID itemId) {
        DietChartItemPK id = new DietChartItemPK(chartId, mealTime, itemId);
        repository.deleteById(id);
    }
}
package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.FoodDTO;
import com.ayurveda.diet.entity.Food;
import com.ayurveda.diet.mapper.FoodMapper;
import com.ayurveda.diet.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository repository;
    private final FoodMapper mapper;

    public FoodDTO create(FoodDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<FoodDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public FoodDTO getById(UUID id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Food not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

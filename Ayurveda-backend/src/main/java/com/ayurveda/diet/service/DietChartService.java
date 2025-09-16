package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.DietChartDTO;
import com.ayurveda.diet.entity.DietChart;
import com.ayurveda.diet.mapper.DietChartMapper;
import com.ayurveda.diet.repository.DietChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DietChartService {

    private final DietChartRepository repository;
    private final DietChartMapper mapper;

    

    public DietChartDTO create(DietChartDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<DietChartDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public DietChartDTO getById(UUID id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Diet chart not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
    
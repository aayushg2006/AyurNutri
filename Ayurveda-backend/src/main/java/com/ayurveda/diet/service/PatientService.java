package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.PatientDTO;
import com.ayurveda.diet.entity.Patient;
import com.ayurveda.diet.mapper.PatientMapper;
import com.ayurveda.diet.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientDTO create(PatientDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<PatientDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public PatientDTO getById(UUID id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

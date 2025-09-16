package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.FeedbackDTO;
import com.ayurveda.diet.entity.Feedback;
import com.ayurveda.diet.mapper.FeedbackMapper;
import com.ayurveda.diet.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedbackService {

    private final FeedbackRepository repository;
    private final FeedbackMapper mapper;

    public FeedbackDTO create(FeedbackDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public List<FeedbackDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public FeedbackDTO getById(UUID id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}

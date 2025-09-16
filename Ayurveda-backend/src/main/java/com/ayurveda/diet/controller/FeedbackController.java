package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.FeedbackDTO;
import com.ayurveda.diet.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService service;

    @PostMapping
    public FeedbackDTO create(@RequestBody FeedbackDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<FeedbackDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FeedbackDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

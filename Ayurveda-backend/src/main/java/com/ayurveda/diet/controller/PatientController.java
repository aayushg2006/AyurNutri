package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.PatientDTO;
import com.ayurveda.diet.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @PostMapping
    public PatientDTO create(@RequestBody PatientDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<PatientDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PatientDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

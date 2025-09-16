// FileName: src/main/java/com/ayurveda/diet/controller/ProgressController.java
package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.PatientDailyLogDTO;
import com.ayurveda.diet.entity.PatientDailyLog;
import com.ayurveda.diet.mapper.PatientDailyLogMapper;
import com.ayurveda.diet.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class ProgressController {

    private final ProgressService service;
    private final PatientDailyLogMapper mapper;

    @GetMapping("/log/today")
    public PatientDailyLogDTO getTodaysLog(@RequestParam UUID patientId) {
        // For the MVP, we are passing the patientId as a parameter.
        // In a real app with security, you'd get this from the logged-in user's token.
        return mapper.toDto(service.getOrCreateTodaysLog(patientId));
    }

    @PutMapping("/log")
    public PatientDailyLogDTO updateTodaysLog(@RequestBody PatientDailyLogDTO dto) {
        PatientDailyLog entity = mapper.toEntity(dto);
        return mapper.toDto(service.updateLog(entity));
    }
}
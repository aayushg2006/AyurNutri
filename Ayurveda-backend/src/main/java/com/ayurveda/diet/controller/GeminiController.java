// FileName: src/main/java/com/ayurveda/diet/controller/GeminiController.java
package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.GeminiRequestDTO; // You will need to create this simple DTO
import com.ayurveda.diet.service.GeminiSuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suggestions")
@RequiredArgsConstructor
public class GeminiController {

    private final GeminiSuggestionService geminiService;

    @PostMapping("/generate")
    public String getSuggestion(@RequestBody GeminiRequestDTO request) {
        // The DTO just holds the two strings from the frontend
        return geminiService.getAiSuggestion(
            request.getPatientCondition(), 
            request.getMealRequest()
        );
    }
}
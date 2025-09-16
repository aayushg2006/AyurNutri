// FileName: src/main/java/com/ayurveda/diet/controller/AnalysisController.java
package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.AnalysisReportDTO;
import com.ayurveda.diet.dto.DietChartItemDTO;
import com.ayurveda.diet.service.AyurvedaAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analysis")
@RequiredArgsConstructor
public class AnalysisController {

    private final AyurvedaAnalysisService analysisService;

    /**
     * This is the endpoint your "Diet Chart Creator" UI will call
     * every time the doctor adds or removes a food.
     * It sends the whole list of items in the meal and gets back the analysis.
     */
    @PostMapping("/calculate")
    public AnalysisReportDTO calculateMealStats(@RequestBody List<DietChartItemDTO> items) {
        // We are receiving a List of items directly.
        return analysisService.analyzeMeal(items);
    }
}
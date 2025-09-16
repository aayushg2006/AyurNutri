// FileName: src/main/java/com/ayurveda/diet/service/AyurvedaAnalysisService.java
package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.AnalysisReportDTO;
import com.ayurveda.diet.dto.DietChartItemDTO; // We re-use this DTO for the request
import com.ayurveda.diet.entity.Food;
import com.ayurveda.diet.repository.FoodRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AyurvedaAnalysisService {

    private final FoodRepository foodRepository;

    // This is the main "brain" function
    public AnalysisReportDTO analyzeMeal(List<DietChartItemDTO> items) {

        AnalysisReportDTO report = new AnalysisReportDTO();
        report.setViryaCount(new HashMap<>());
        report.setRasaCount(new HashMap<>());
        report.setGunaCount(new HashMap<>());

        double totalCalories = 0;
        double totalProtein = 0;
        double totalFat = 0;
        double totalCarbs = 0;

        // Loop through every item the doctor put in the chart
        for (DietChartItemDTO item : items) {

            // 1. Get the food data from the database
            Optional<Food> foodOpt = foodRepository.findById(item.getItemId());
            if (foodOpt.isEmpty()) {
                continue; // Skip if food isn't found
            }
            Food food = foodOpt.get();

            // 2. Calculate nutritional values based on quantity
            // (All food data in your DB is per 100g)
            double ratio = item.getQuantityG() / 100.0;
            totalCalories += food.getCaloriesPer100g() * ratio;
            totalProtein += food.getProteinG() * ratio;
            totalFat += food.getFatG() * ratio;
            totalCarbs += food.getCarbsG() * ratio;

            // 3. Analyze the Ayurvedic JSONB properties
            JsonNode props = food.getAyurvedaProps();
            if (props != null) {
                // Tally the Rasa (Taste) - assuming it's a text field
                tallyProperty(props, "rasa", report.getRasaCount());

                // Tally the Virya (Potency) - assuming it's a text field
                tallyProperty(props, "virya", report.getViryaCount());

                // Tally the Gunas (Qualities) - assuming it's an ARRAY of text
                tallyPropertiesArray(props, "guna", report.getGunaCount());
            }
        }

        // 4. Set the final calculated totals
        report.setTotalCalories(totalCalories);
        report.setTotalProtein(totalProtein);
        report.setTotalFat(totalFat);
        report.setTotalCarbs(totalCarbs);

        return report;
    }

    // --- Helper methods for the analysis ---

    private void tallyProperty(JsonNode props, String key, Map<String, Integer> countMap) {
        if (props.has(key) && !props.get(key).isNull()) {
            String value = props.get(key).asText();
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
    }

    private void tallyPropertiesArray(JsonNode props, String key, Map<String, Integer> countMap) {
        if (props.has(key) && props.get(key).isArray()) {
            for (JsonNode node : props.get(key)) {
                String value = node.asText();
                countMap.put(value, countMap.getOrDefault(value, 0) + 1);
            }
        }
    }
}
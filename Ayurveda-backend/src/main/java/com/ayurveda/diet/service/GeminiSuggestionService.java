// FileName: src/main/java/com/ayurveda/diet/service/GeminiSuggestionService.java
package com.ayurveda.diet.service;

import com.ayurveda.diet.entity.Food;
import com.ayurveda.diet.repository.FoodRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeminiSuggestionService {

    private final RestTemplate restTemplate;
    private final FoodRepository foodRepository;
    // Jackson is included with Spring Boot, we can just create it
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${gemini.api.key}")
    private String apiKey;

    public String getAiSuggestion(String patientCondition, String mealRequest) {

        // 1. Get all 150 foods from YOUR database
        List<Food> foodDatabase = foodRepository.findAll();

        // 2. Convert your food data to a simple JSON string to send to the AI
        String foodJsonList;
        try {
            foodJsonList = convertFoodListToJson(foodDatabase);
        } catch (JsonProcessingException e) {
            return "{\"error\": \"Failed to serialize local food data.\"}";
        }

        // 3. Build the Master Prompt for Gemini
        String prompt = String.format(
                "You are an expert Ayurvedic diet counselor. A patient has the condition: %s. " +
                        "Your task is to generate a %s (e.g., 'a 500-calorie breakfast'). " +
                        "You MUST ONLY use foods from the following JSON list: %s. " +
                        "Your response MUST be a single, valid JSON object in this exact format: " +
                        "{\"suggestion\": [{\"name\": \"Food Name 1\", \"quantity_g\": 100}, {\"name\": \"Food Name 2\", \"quantity_g\": 50}]}",
                patientCondition, mealRequest, foodJsonList);

        // 4. Set up the Gemini API Call
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key="
                + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the complex JSON request body required by the Gemini API
        Map<String, Object> textPart = Map.of("text", prompt);
        Map<String, Object> contentPart = Map.of("parts", List.of(textPart));
        Map<String, Object> requestBody = Map.of("contents", List.of(contentPart));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // 5. Make the API call
        String geminiResponse = restTemplate.postForObject(apiUrl, entity, String.class);

        // 6. Parse the complex response to get ONLY the JSON diet plan we asked for
        return extractJsonFromGeminiResponse(geminiResponse);
    }

    // Helper to convert your food list to a simple JSON for the prompt
    private String convertFoodListToJson(List<Food> foods) throws JsonProcessingException {
        List<Map<String, Object>> simpleFoods = foods.stream()
                .map(food -> Map.of(
                        "name", food.getName(),
                        "caloriesPer100g", food.getCaloriesPer100g(),
                        "properties", food.getAyurvedaProps()))
                .collect(Collectors.toList());
        return objectMapper.writeValueAsString(simpleFoods);
    }

    // Helper to dig into the Gemini response and extract the clean JSON text
    private String extractJsonFromGeminiResponse(String rawJson) {
        try {
            JsonNode root = objectMapper.readTree(rawJson);
            // This is the path to the actual text response from Gemini
            String text = root.at("/candidates/0/content/parts/0/text").asText();

            // This finds the JSON block *inside* that text
            int jsonStart = text.indexOf('{');
            int jsonEnd = text.lastIndexOf('}');
            if (jsonStart != -1 && jsonEnd != -1) {
                return text.substring(jsonStart, jsonEnd + 1);
            }
            return "{\"error\": \"Failed to parse AI response text\"}";
        } catch (Exception e) {
            return "{\"error\": \"Error parsing Gemini JSON: " + e.getMessage() + "\"}";
        }
    }
}
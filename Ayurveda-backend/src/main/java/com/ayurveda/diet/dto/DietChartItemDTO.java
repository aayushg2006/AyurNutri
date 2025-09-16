package com.ayurveda.diet.dto;

import lombok.*;
import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DietChartItemDTO {
    private UUID chartId;
    private String mealTime;
    private String itemType; // food | recipe
    private UUID itemId;
    private Double quantityG;
    private LocalTime timeOfDay;
}

// FileName: src/main/java/com/ayurveda/diet/entity/DietChartItem.java
package com.ayurveda.diet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "diet_chart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(DietChartItemPK.class) // Use the correct PK class
public class DietChartItem {

    @Id
    @Column(name = "chart_id")
    private UUID chartId;

    @Id
    @Column(name = "meal_time")
    private String mealTime;

    @Id
    @Column(name = "item_id")
    private UUID itemId;

    @Column(name = "item_type", nullable = false)
    private String itemType; // 'food' or 'recipe'

    // --- THIS IS THE FIX ---
    @Column(name = "quantity_g", columnDefinition = "numeric")
    private Double quantityG; 

    @Column(name = "time_of_day")
    private LocalTime timeOfDay; 
}
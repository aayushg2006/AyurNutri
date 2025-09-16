// FileName: src/main/java/com/ayurveda/diet/entity/Food.java
package com.ayurveda.diet.entity;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "foods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {

    @Id
    @GeneratedValue
    @Column(name = "food_id", updatable = false, nullable = false)
    private UUID foodId;

    private String name;

    private String category;

    // --- THESE ARE THE FIXES ---
    @Column(name = "calories_per_100g", columnDefinition = "numeric")
    private Double caloriesPer100g;

    @Column(name = "protein_g", columnDefinition = "numeric")
    private Double proteinG;

    @Column(name = "fat_g", columnDefinition = "numeric")
    private Double fatG;

    @Column(name = "carbs_g", columnDefinition = "numeric")
    private Double carbsG;
    // --- END FIXES ---

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private JsonNode ayurvedaProps;

    @Column(name = "is_seasonal")
    private Boolean isSeasonal;
}
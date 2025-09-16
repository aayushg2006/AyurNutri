// FileName: src/main/java/com/ayurveda/diet/entity/DietChartItemPK.java
package com.ayurveda.diet.entity;

import java.io.Serializable;
import java.util.UUID;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DietChartItemPK implements Serializable {
    
    private UUID chartId;
    private String mealTime;
    private UUID itemId;
}
// FileName: src/main/java/com/ayurveda/diet/repository/DietChartItemRepository.java
package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.DietChartItem;
import com.ayurveda.diet.entity.DietChartItemPK; // Use the new PK class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
// Use the new PK class in the signature
public interface DietChartItemRepository extends JpaRepository<DietChartItem, DietChartItemPK> {
    
    // Methods are updated to match the correct entity fields:
    
    List<DietChartItem> findByChartId(UUID chartId);

    List<DietChartItem> findByChartIdAndMealTime(UUID chartId, String mealTime);
    
    List<DietChartItem> findByItemId(UUID itemId);
}
// FileName: src/main/java/com/ayurveda/diet/mapper/DietChartItemMapper.java
package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.DietChartItem;
import com.ayurveda.diet.dto.DietChartItemDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DietChartItemMapper {
    // All fields now match, so no @Mapping is needed!
    DietChartItemDTO toDto(DietChartItem entity);
    DietChartItem toEntity(DietChartItemDTO dto);
}
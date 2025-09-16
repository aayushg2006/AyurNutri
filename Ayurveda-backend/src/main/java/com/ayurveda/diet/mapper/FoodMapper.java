package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.Food;
import com.ayurveda.diet.dto.FoodDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodDTO toDto(Food entity);
    Food toEntity(FoodDTO dto);
}

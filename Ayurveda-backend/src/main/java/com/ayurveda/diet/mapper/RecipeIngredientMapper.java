package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.RecipeIngredient;
import com.ayurveda.diet.dto.RecipeIngredientDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecipeIngredientMapper {
    RecipeIngredientDTO toDto(RecipeIngredient entity);
    RecipeIngredient toEntity(RecipeIngredientDTO dto);
}

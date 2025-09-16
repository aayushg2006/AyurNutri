package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.Recipe;
import com.ayurveda.diet.dto.RecipeDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    @Mapping(source = "creator.userId", target = "creatorId")
    RecipeDTO toDto(Recipe entity);

    @Mapping(source = "creatorId", target = "creator.userId")
    Recipe toEntity(RecipeDTO dto);
}

package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.Feedback;
import com.ayurveda.diet.dto.FeedbackDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    @Mapping(source = "patient.patientId", target = "patientId")
    @Mapping(source = "chart.chartId", target = "chartId")
    FeedbackDTO toDto(Feedback entity);

    @Mapping(source = "patientId", target = "patient.patientId")
    @Mapping(source = "chartId", target = "chart.chartId")
    Feedback toEntity(FeedbackDTO dto);
}

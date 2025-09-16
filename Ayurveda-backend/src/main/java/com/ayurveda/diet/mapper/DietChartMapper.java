package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.DietChart;
import com.ayurveda.diet.dto.DietChartDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface DietChartMapper {
    @Mapping(source = "patient.patientId", target = "patientId")
    @Mapping(source = "doctor.userId", target = "doctorId")
    DietChartDTO toDto(DietChart entity);

    @Mapping(source = "patientId", target = "patient.patientId")
    @Mapping(source = "doctorId", target = "doctor.userId")
    DietChart toEntity(DietChartDTO dto);
}

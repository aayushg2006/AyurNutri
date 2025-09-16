package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.Patient;
import com.ayurveda.diet.dto.PatientDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO toDto(Patient entity);

    // ✅ FIX: Added this mapping to set the 'user' field
    // This resolves the "Unmapped target property" warning.
    @Mapping(source = "patientId", target = "user.userId")
    Patient toEntity(PatientDTO dto);
}
// FileName: src/main/java/com/ayurveda/diet/mapper/PatientDailyLogMapper.java
package com.ayurveda.diet.mapper;

import com.ayurveda.diet.dto.PatientDailyLogDTO;
import com.ayurveda.diet.entity.PatientDailyLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientDailyLogMapper {
    PatientDailyLogDTO toDto(PatientDailyLog entity);
    PatientDailyLog toEntity(PatientDailyLogDTO dto);
}
// FileName: src/main/java/com/ayurveda/diet/repository/PatientDailyLogRepository.java
package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.PatientDailyLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientDailyLogRepository extends JpaRepository<PatientDailyLog, UUID> {
    // This method finds a log for a specific patient on a specific date
    Optional<PatientDailyLog> findByPatientIdAndLogDate(UUID patientId, LocalDate date);
}
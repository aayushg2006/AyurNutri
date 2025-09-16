// FileName: src/main/java/com/ayurveda/diet/service/ProgressService.java
package com.ayurveda.diet.service;

import com.ayurveda.diet.entity.PatientDailyLog;
import com.ayurveda.diet.repository.PatientDailyLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgressService {

    private final PatientDailyLogRepository repository;

    // This gets today's log, or creates a new one if it doesn't exist
    public PatientDailyLog getOrCreateTodaysLog(UUID patientId) {
        LocalDate today = LocalDate.now();
        Optional<PatientDailyLog> logOpt = repository.findByPatientIdAndLogDate(patientId, today);

        if (logOpt.isPresent()) {
            return logOpt.get();
        } else {
            PatientDailyLog newLog = new PatientDailyLog();
            newLog.setPatientId(patientId);
            newLog.setLogDate(today);
            // You can set other default values here if needed
            return repository.save(newLog);
        }
    }

    public PatientDailyLog updateLog(PatientDailyLog log) {
        // This makes sure we are saving the log by its correct ID
        if (log.getId() == null) {
            throw new IllegalArgumentException("Cannot update a log without an ID.");
        }
        return repository.save(log);
    }
}
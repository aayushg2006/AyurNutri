// FileName: src/main/java/com/ayurveda/diet/service/DashboardService.java
package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.DashboardStatsDTO;
import com.ayurveda.diet.repository.DietChartRepository;
import com.ayurveda.diet.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final PatientRepository patientRepository;
    private final DietChartRepository dietChartRepository;

    public DashboardStatsDTO getDashboardStats() {
        DashboardStatsDTO stats = new DashboardStatsDTO();

        // 1. Get simple counts
        stats.setActivePatientCount(patientRepository.count());
        stats.setDietChartsCreatedCount(dietChartRepository.count());

        // 2. Get the Dosha distribution data
        List<Object[]> doshaResults = patientRepository.countPatientsByPrakritiType();
        Map<String, Long> doshaDistribution = doshaResults.stream()
                .collect(Collectors.toMap(
                    row -> (String) row[0],  // The prakritiType
                    row -> (Long) row[1]     // The count
                ));
        stats.setDoshaDistribution(doshaDistribution);

        return stats;
    }
}
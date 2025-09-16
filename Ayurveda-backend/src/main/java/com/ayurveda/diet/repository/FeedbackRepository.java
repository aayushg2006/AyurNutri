package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.Feedback;
import com.ayurveda.diet.entity.DietChart;
import com.ayurveda.diet.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
    List<Feedback> findByPatient(Patient patient);
    List<Feedback> findByPatientPatientId(UUID patientId);
    List<Feedback> findByChart(DietChart chart);
    List<Feedback> findByChartChartId(UUID chartId);
}

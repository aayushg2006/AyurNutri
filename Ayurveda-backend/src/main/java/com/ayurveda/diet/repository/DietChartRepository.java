package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.DietChart;
import com.ayurveda.diet.entity.Patient;
import com.ayurveda.diet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DietChartRepository extends JpaRepository<DietChart, UUID> {
    List<DietChart> findByPatient(Patient patient);
    List<DietChart> findByPatientPatientId(UUID patientId);
    List<DietChart> findByDoctor(User doctor);
    List<DietChart> findByDoctorUserId(UUID doctorId);
}

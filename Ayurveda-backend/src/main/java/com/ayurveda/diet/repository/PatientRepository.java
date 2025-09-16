// FileName: src/main/java/com/ayurveda/diet/repository/PatientRepository.java
package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Add this import
import org.springframework.stereotype.Repository;

import java.util.List; // Add this import
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    
    // --- ADD THIS NEW METHOD ---
    /**
     * This query groups all patients by their constitution (prakritiType)
     * and returns the count for each type. This is for the dashboard pie chart.
     */
    @Query("SELECT p.prakritiType, COUNT(p) FROM Patient p GROUP BY p.prakritiType")
    List<Object[]> countPatientsByPrakritiType();
    // --- END ---
}
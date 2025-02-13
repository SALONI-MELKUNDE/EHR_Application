package com.ehr.repo;

import com.ehr.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // ✅ Required to mark this as a Spring-managed repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {


    Prescription findByPatientIdAndMedicineName(Long patientId, String medicineName);
}




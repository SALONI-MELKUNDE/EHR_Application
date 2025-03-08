package com.ehr.repo;

import com.ehr.entity.Prescription;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  // ✅ Required to mark this as a Spring-managed repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {









    void deleteByPatientId(Long patientId);

    List<Prescription> findByPatientId(Long patientId);

}





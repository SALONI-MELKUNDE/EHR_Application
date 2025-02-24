package com.ehr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehr.entity.Patient;

@Repository  // ✅ Required to mark this as a Spring-managed repository
public interface PatientRepository extends JpaRepository<Patient, Long> {



	List<Patient> findByPatientId(Long patientId);
}
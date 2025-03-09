package com.ehr.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehr.entity.Patient;

import java.util.List;

@Repository  // ✅ Required to mark this as a Spring-managed repository
public interface PatientRepository extends MongoRepository<Patient, Long> {


    List<Patient> findByPatientId(String patientId);




    boolean existsByPatientId(String patientId);

    void deleteByPatientId(String patientId);
}


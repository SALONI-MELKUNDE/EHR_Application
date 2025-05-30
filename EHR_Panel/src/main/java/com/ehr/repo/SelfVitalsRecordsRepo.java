package com.ehr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehr.entity.SelfVitalsRecords;

import java.util.Optional;


@Repository
public interface SelfVitalsRecordsRepo extends JpaRepository<SelfVitalsRecords, Long> {


    //Optional<SelfVitalsRecords> findByPatient_id(Long patient_id);

    Optional<SelfVitalsRecords> findByPatientId(Long patientId);

    void deleteByPatientId(Long patientId);
}
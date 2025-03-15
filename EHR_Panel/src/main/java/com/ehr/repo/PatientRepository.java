

package com.ehr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ehr.entity.Patient;

@Repository  //
public interface PatientRepository extends JpaRepository<Patient, Long> {


    boolean existsById(Long patientId);


    List<Patient> findByPatientId(Long patientId);
}
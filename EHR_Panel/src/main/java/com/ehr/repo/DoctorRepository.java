package com.ehr.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehr.entity.Doctor;
@Repository  //
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    List<Doctor> findByDoctorId(Long doctorId);


    boolean existsById(Long doctorId);
}





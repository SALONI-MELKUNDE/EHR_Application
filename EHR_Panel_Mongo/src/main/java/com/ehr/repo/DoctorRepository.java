package com.ehr.repo;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ehr.entity.Doctor;
@Repository  // ✅ Required to mark this as a Spring-managed repository
public interface DoctorRepository extends MongoRepository<Doctor, Long> {


}



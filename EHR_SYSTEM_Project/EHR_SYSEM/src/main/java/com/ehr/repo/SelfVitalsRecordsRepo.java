package com.ehr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehr.entity.SelfVitalsRecords;


@Repository  // ✅ Required to mark this as a Spring-managed repository
public interface SelfVitalsRecordsRepo extends JpaRepository<SelfVitalsRecords, Long> {






}

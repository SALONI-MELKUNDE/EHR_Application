package com.ehr.service;


import java.util.List;


import com.ehr.entity.Doctor;
import com.ehr.entity.Patient;
import com.ehr.entity.Prescription;
import com.ehr.entity.SelfVitalsRecords;


public interface PatientService {


	Patient savePatient(Patient patient);

	Doctor saveDoctor(Doctor doctor);




	SelfVitalsRecords selfVitalsRecords(SelfVitalsRecords selfVitalsRecords);

	    List<Doctor> findAll();

	    List<Doctor> findByDoctorId(Long doctorId);

	    List<Patient> getAllPatients();

	    List<Patient> findByPatientId(Long patientId);

	Prescription savePrescription(Prescription prescription);

	String getScheduleForPatientAndMedicine(Long patientId, String medicineName);

}



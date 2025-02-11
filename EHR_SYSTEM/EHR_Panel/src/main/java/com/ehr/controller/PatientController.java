package com.ehr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ehr.entity.Patient;
import com.ehr.entity.SelfVitalsRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ehr.entity.Doctor;

import com.ehr.service.PatientService;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PatientController {

	@Autowired
	PatientService patientService;

	//addPatients

	@PostMapping("/addPatients")
	public ResponseEntity<Map<String, Object>> addPatient(@RequestBody Patient patient) {
		Patient savedPatient = patientService.savePatient(patient);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Patient registered successfully");
		response.put("patient", savedPatient);

		return ResponseEntity.ok(response);
	}



	@GetMapping("/getAllDoctorRecords")
	public List<Doctor> getAllDoctorRecords() {
		return patientService.findAll();
	}

	@GetMapping("/doctor/{doctorId}")
	public List<Doctor> getDoctorByDoctorId(@PathVariable Long doctorId) {

		System.out.println("Received doctorId: " + doctorId);

		return patientService.findByDoctorId(doctorId);
	}




	@PostMapping("/SelfVitalsRecords")
	public ResponseEntity<Map<String, Object>> SelfVitalsRecords(@RequestBody SelfVitalsRecords selfVitalsRecords) {
		SelfVitalsRecords savedselfVitalsRecords = patientService.selfVitalsRecords(selfVitalsRecords);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "selfVitalsRecords registered successfully");
		response.put("selfVitalsRecords", savedselfVitalsRecords);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	// Get patient by ID
	@GetMapping("/patient/{patientId}")
	public List<Patient> getPatientById(@PathVariable Long patientId) {
		return patientService.findByPatientId(patientId);
	}


	@PostMapping("/addDoctors")
	public ResponseEntity<Map<String, Object>> addDoctor(@RequestBody Doctor doctor) {
		Doctor savedDoctor = patientService.saveDoctor(doctor);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Doctor registered successfully");
		response.put("doctor", savedDoctor);




		return ResponseEntity.ok(response);
	}
}



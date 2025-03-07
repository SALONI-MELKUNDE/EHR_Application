package com.ehr.controller;

import com.ehr.entity.*;
import com.ehr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.*;

@RestController
@RequestMapping
public class PatientController {

	@Autowired
	PatientService patientService;



	// ✅ Add Patient with Validation
	@PostMapping("/addPatients")
	public ResponseEntity<Map<String, Object>> addPatient(@Valid @RequestBody Patient patient) {
		Patient savedPatient = patientService.savePatient(patient);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Patient registered successfully");
		//response.put("patient", savedPatient);

		return ResponseEntity.ok(response);
	}

	// ✅ Get All Doctors
	@GetMapping("/getAllDoctorRecords")
	public List<Doctor> getAllDoctorRecords() {
		return patientService.findAll();
	}

	// ✅ Get Doctor by ID (Validation Added)
	@GetMapping("/doctor/{doctorId}")
	public ResponseEntity<?> getDoctorByDoctorId(@PathVariable @NotNull Long doctorId) {
		List<Doctor> doctors = patientService.findByDoctorId(doctorId);

		if (doctors.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No doctor found with ID: " + doctorId);
		}
		return ResponseEntity.ok(doctors);
	}

	@DeleteMapping("/doctorDelete/{doctorId}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable @NotNull Long doctorId) {
		boolean isDeleted = patientService.deleteDoctorById(doctorId);

		if (isDeleted) {
			return ResponseEntity.ok("Deleted doctor with ID: " + doctorId);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No doctor found with ID: " + doctorId);
	}
	@PutMapping("/doctorUpdate/{doctorId}")
	public ResponseEntity<?> updateDoctorById(@PathVariable @NotNull Long doctorId, @Valid @RequestBody Doctor updatedDoctor) {
		Doctor doctor = patientService.updateDoctorById(doctorId, updatedDoctor);

		if (doctor != null) {
			return ResponseEntity.ok(doctor);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No doctor found with ID: " + doctorId);
	}


	// ✅ Add Self Vitals Record with Validation
	@PostMapping("/SelfVitalsRecords")
	public ResponseEntity<Map<String, Object>> selfVitalsRecords(@Valid @RequestBody SelfVitalsRecords selfVitalsRecords) {
		SelfVitalsRecords savedVitals = patientService.selfVitalsRecords(selfVitalsRecords);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Self Vitals Record saved successfully");
		//response.put("selfVitalsRecords", savedVitals);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/getAllSefVitalRecords")
	public ResponseEntity<List<SelfVitalsRecords>> getAllSelfVitalsRecords() {
		System.out.println("Fetching self vitals records..."); // Debug log
		List<SelfVitalsRecords> vitalsRecords = patientService.getAllSelfVitalsRecords();

		if (vitalsRecords.isEmpty()) {
			System.out.println("No records found!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Collections.emptyList());
		}
		System.out.println("Records found: " + vitalsRecords.size());
		return ResponseEntity.ok(vitalsRecords);
	}

	@GetMapping("/getSelfVitalRecordsByPatient/{patientId}")
	public ResponseEntity<List<Object>> getSelfVitalRecordsByPatientId(@PathVariable Long patientId) {
		System.out.println("Fetching self vital records for Patient ID: " + patientId); // Debug log

		Optional<SelfVitalsRecords> vitalRecords = patientService.getSelfVitalRecordsByPatientId(patientId);

		if (vitalRecords.isEmpty()) {
			System.out.println("No records found for Patient ID: " + patientId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
		}
		return ResponseEntity.ok(Collections.singletonList(vitalRecords));
	}



	// ✅ Get All Patients
	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}


	@DeleteMapping("/patientDelete/{patientId}")
	public ResponseEntity<String> deletePatientById(@PathVariable @NotNull Long patientId) {
		if (patientService.deletedPatientById(patientId)) {
			return ResponseEntity.ok("Deleted patient with ID: " + patientId);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No patient found with ID: " + patientId);
	}

	@PutMapping("/patientUpdate/{patientId}")
	public ResponseEntity<?> updatePatientById(@PathVariable @NotNull Long patientId,
											   @Valid @RequestBody Patient updatedPatient) {
		Patient patient = patientService.updatePatientById(patientId, updatedPatient);

		if (patient != null) {
			return ResponseEntity.ok(patient);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("No patient found with ID: " + patientId);
	}


	// ✅ Get Patient by ID with Validation
	@GetMapping("/patient/{patientId}")
	public ResponseEntity<?> getPatientById(@PathVariable @NotNull Long patientId) {
		List<Patient> patients = patientService.findByPatientId(patientId);

		if (patients.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No patient found with ID: " + patientId);
		}
		return ResponseEntity.ok(patients);
	}

	// ✅ Add Doctor with Validation

	@PostMapping("/addDoctors")
	public ResponseEntity<Map<String, Object>> addDoctor(@Valid @RequestBody Doctor doctor) {
		Doctor savedDoctor = patientService.saveDoctor(doctor);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Doctor registered successfully");
		//response.put("doctor", savedDoctor);

		return ResponseEntity.ok(response);
	}


	@PostMapping("/prescription")
	public ResponseEntity<Map<String, Object>> savePrescription(@Valid @RequestBody Prescription prescription) {
		// Check if the patient ID exists in the Patient_Detail_Record table
		boolean isPatientExists = patientService.isPatientExists(prescription.getPatientId());

		if (!isPatientExists) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(Collections.singletonMap("error", "Patient ID not found in Patient_Detail_Record"));
		}

		// Save prescription if patient exists
		Prescription savedPrescription = patientService.savePrescription(prescription);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Prescription saved successfully");
		response.put("prescription", savedPrescription);

		return ResponseEntity.ok(response);
	}



	@GetMapping("/getPrescription")
	public ResponseEntity<String> getSchedule(@RequestParam("patientId") @NotNull Long patientId) {
		List<String> schedules = patientService.getSchedulesForPatient(patientId);

		if (schedules == null || schedules.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No schedule found for patient ID: " + patientId);
		}

		// Combine all schedules into one response, joining each schedule with a newline
		return ResponseEntity.ok("The prescribed time slots for patient ID " + patientId + " are:\n" + String.join("\n\n", schedules));
	}




	// ✅ Add a new appointment
/*	@PostMapping("/addAppointment")
	public ResponseEntity<Map<String, Object>> addAppointment(@RequestBody Appointment appointment) {
		Appointment savedAppointment = patientService.saveAppointment(appointment);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Appointment scheduled successfully");
		//response.put("appointment", savedAppointment);

		return ResponseEntity.ok(response);
	}*/
	@PostMapping("/addAppointment")
	public ResponseEntity<Map<String, Object>> addAppointment(@RequestBody Appointment appointment) {
		// Check if patient exists
		boolean isPatientExists = patientService.isPatientExists(appointment.getPatient_id());

		if (!isPatientExists) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(Collections.singletonMap("error", "Patient ID " + appointment.getPatient_id() + " not found."));
		}

		// If patient exists, save appointment
		Appointment savedAppointment = patientService.saveAppointment(appointment);

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Appointment scheduled successfully");
		response.put("appointment", savedAppointment);

		return ResponseEntity.ok(response);
	}






	// ✅ Get all appointments
	@GetMapping("/allAppointment")
	public ResponseEntity<List<Appointment>> getAllAppointments() {
		List<Appointment> appointments = patientService.getAllAppointments();
		return ResponseEntity.ok(appointments);
	}


	@GetMapping("/appointment/{appointmentId}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable String appointmentId) {
		return patientService.getAppointmentById(appointmentId)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}


	// ✅ Global Exception Handler for Bad Requests
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("❌ Error: " + ex.getMessage());
	}





}

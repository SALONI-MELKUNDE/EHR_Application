package com.ehr.service;


import com.ehr.entity.*;
import com.ehr.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	SelfVitalsRecordsRepo selfVitalsRecordsRepo;


	@Autowired
	PrescriptionRepository prescriptionRepository;

	@Autowired
	AppointmentRepository appointmentRepository;


	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public boolean deletedPatientById(Long patientId) {
		if (patientRepository.existsById(patientId)) {
			patientRepository.deleteById(patientId);
			return true; // Successfully deleted
		}
		return false; // Patient ID not found
	}

	@Override
	public boolean deleteDoctorById(Long doctorId) {
		if (doctorRepository.existsById(doctorId)) {
			doctorRepository.deleteById(doctorId);
			return true;
		}
		return false;
	}

	@Override
	public Doctor updateDoctorById(Long doctorId, Doctor updatedDoctor) {
		Optional<Doctor> existingDoctorOpt = doctorRepository.findById(doctorId);

		if (existingDoctorOpt.isPresent()) {
			Doctor existingDoctor = existingDoctorOpt.get();

			// Updating only non-null fields
			if (updatedDoctor.getDoctorName() != null) {
				existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
			}
			if (updatedDoctor.getDoctorGender() != null) {
				existingDoctor.setDoctorGender(updatedDoctor.getDoctorGender());
			}
			if (updatedDoctor.getPurposeOfVisit() != null) {
				existingDoctor.setPurposeOfVisit(updatedDoctor.getPurposeOfVisit());
			}
			if (updatedDoctor.getDiagnosisRecommendation() != null) {
				existingDoctor.setDiagnosisRecommendation(updatedDoctor.getDiagnosisRecommendation());
			}
			if (updatedDoctor.getDoctorPhone() != null) {
				existingDoctor.setDoctorPhone(updatedDoctor.getDoctorPhone());
			}
			if (updatedDoctor.getDoctorEmail() != null) {
				existingDoctor.setDoctorEmail(updatedDoctor.getDoctorEmail());
			}
			if (updatedDoctor.getSelfAge() > 0) {
				existingDoctor.setSelfAge(updatedDoctor.getSelfAge());
			}
			if (updatedDoctor.getDateOfVisit() != null) {
				existingDoctor.setDateOfVisit(updatedDoctor.getDateOfVisit());
			}
			if (updatedDoctor.getSelfMedicalDocs() != null) {
				existingDoctor.setSelfMedicalDocs(updatedDoctor.getSelfMedicalDocs());
			}

			// Save updated doctor details
			return doctorRepository.save(existingDoctor);
		} else {
			return null; // No doctor found
		}
	}



	@Override
	public Patient updatePatientById(Long patientId, Patient updatedPatient) {
		Optional<Patient> existingPatient = patientRepository.findById(patientId);

		if (existingPatient.isPresent()) {
			Patient patient = existingPatient.get();
			patient.setPatientName(updatedPatient.getPatientName());
			patient.setPatientAge(updatedPatient.getPatientAge());
			patient.setPatientGender(updatedPatient.getPatientGender());
			patient.setPurposeOfVisit(updatedPatient.getPurposeOfVisit());
			patient.setDiagnosisRecommendation(updatedPatient.getDiagnosisRecommendation());
			patient.setPatientPhone(updatedPatient.getPatientPhone());
			patient.setPatientEmail(updatedPatient.getPatientEmail());
			patient.setPatientDateOfVisit(updatedPatient.getPatientDateOfVisit());
			patient.setPatientMedicalDocs(updatedPatient.getPatientMedicalDocs());

			return patientRepository.save(patient); // Save and return updated patient
		}
		return null; // If not found, return null
	}



	public SelfVitalsRecords selfVitalsRecords(SelfVitalsRecords selfVitalsRecords) {
		// Evaluating each vital and setting the status
		selfVitalsRecords.setHeartRateStatus(evaluateHeartRate(selfVitalsRecords.getHeartRate()));
		selfVitalsRecords.setBloodPressureStatus(evaluateBloodPressure(selfVitalsRecords.getBloodPressure()));
		selfVitalsRecords.setRespiratoryRateStatus(evaluateRespiratoryRate(selfVitalsRecords.getRespiratoryRate()));
		selfVitalsRecords.setBodyTemperatureStatus(evaluateBodyTemperature(selfVitalsRecords.getBodyTemperature()));
		selfVitalsRecords.setBloodGlucoseStatus(evaluateBloodGlucose(selfVitalsRecords.getBloodGlucose()));
		selfVitalsRecords.setOxygenSaturationStatus(evaluateOxygenSaturation(selfVitalsRecords.getOxygenSaturation()));

		// Saving the evaluated vitals in the database
		return selfVitalsRecordsRepo.save(selfVitalsRecords);
	}

	// Logic to evaluate Heart Rate status
	private String evaluateHeartRate(int heartRate) {
		if (heartRate < 40) {
			return "Low Heart Rate";
		} else if (heartRate > 130) {
			return "High Heart Rate";
		} else {
			return "Normal Range";
		}
	}

	// Logic to evaluate Blood Pressure status
	private String evaluateBloodPressure(int bloodPressure) {


		if (bloodPressure < 90) {
			return "Low Blood Pressure";
		} else if (bloodPressure > 90) {
			return "High Blood Pressure";
		} else {
			return "Normal Range";
		}
	}

	// Logic to evaluate Respiratory Rate status
	private String evaluateRespiratoryRate(int respiratoryRate) {
		if (respiratoryRate < 8) {
			return "Low Respiratory Rate";
		} else if (respiratoryRate > 30) {
			return "High Respiratory Rate";
		} else {
			return "Normal Range";
		}
	}

	// Logic to evaluate Body Temperature status
	private String evaluateBodyTemperature(double bodyTemperature) {
		if (bodyTemperature < 95) {
			return "Low Body Temperature";
		} else if (bodyTemperature > 100) {
			return "High Body Temperature";
		} else {
			return "Normal Range";
		}
	}

	// Logic to evaluate Blood Glucose status
	private String evaluateBloodGlucose(double bloodGlucose) {
		if (bloodGlucose < 60) {
			return "Low Blood Glucose";
		} else if (bloodGlucose > 126) {
			return "High Blood Glucose";
		} else {
			return "Normal Range";
		}
	}

	// Logic to evaluate Oxygen Saturation status
	private String evaluateOxygenSaturation(double oxygenSaturation) {
		if (oxygenSaturation < 88) {
			return "Low Oxygen Saturation";
		} else if (oxygenSaturation > 92) {
			return "High Oxygen Saturation";
		} else {
			return "Normal Range";
		}
	}


	@Override
	public List<Doctor> findAll() {

		return doctorRepository.findAll();
	}


	@Override
	public List<Doctor> findByDoctorId(Long doctorId) {

		return doctorRepository.findByDoctorId(doctorId);
	}


	public List<Patient> getAllPatients() {

		return patientRepository.findAll();
	}


	public List<Patient> findByPatientId(Long patientId) {

		return patientRepository.findByPatientId(patientId);
	}

	@Override
	public Prescription savePrescription(Prescription prescription) {

		int timesPerDay = prescription.getPrescriptionRecommendedXTimesPerDay();

		if (timesPerDay >= 1) {
			prescription.setMorningSlot("8:00 AM - 11:00 AM"); // Morning Slot
		}

		if (timesPerDay >= 2) {
			prescription.setAfternoonSlot("12:00 PM - 3:00 PM"); // Afternoon Slot
		}

		if (timesPerDay == 3) {
			prescription.setEveningSlot("6:00 PM - 9:00 PM"); // Evening Slot
		}
		return prescriptionRepository.save(prescription);
	}


	public List<String> getSchedulesForPatient(Long patientId) {
		List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);

		List<String> schedules = new ArrayList<>();

		if (prescriptions.isEmpty()) {
			return schedules; // No prescriptions found for the patient
		}

		for (Prescription prescription : prescriptions) {
			StringBuilder schedule = new StringBuilder();

			// Start with the medicine name
			schedule.append("Medicine: ").append(prescription.getMedicineName()).append("\n");

			// Add time slots if they are not null
			if (prescription.getMorningSlot() != null) {
				schedule.append("Morning: ").append(prescription.getMorningSlot()).append("\n");
			}

			if (prescription.getAfternoonSlot() != null) {
				schedule.append("Afternoon: ").append(prescription.getAfternoonSlot()).append("\n");
			}

			if (prescription.getEveningSlot() != null) {
				schedule.append("Evening: ").append(prescription.getEveningSlot()).append("\n");
			}

			schedules.add(schedule.toString().trim()); // Add the schedule for this prescription to the list
		}

		return schedules;
	}


	// ✅ Save appointment
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	// ✅ Get all appointments
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	// ✅ Get an appointment by ID
	public Optional<Appointment> getAppointmentById(String appointmentId) {
		return appointmentRepository.findById(appointmentId);
	}

	@Override
	public boolean isPatientExists(Long patientId) {
		return patientRepository.existsById(Long.valueOf(patientId));
	}

	@Override
	public List<SelfVitalsRecords> getAllSelfVitalsRecords() {
		return selfVitalsRecordsRepo.findAll();
	}



}













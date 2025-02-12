package com.ehr.service;


import com.ehr.entity.Doctor;
import com.ehr.entity.Patient;
import com.ehr.entity.SelfVitalsRecords;
import com.ehr.repo.DoctorRepository;
import com.ehr.repo.PatientRepository;
import com.ehr.repo.SelfVitalsRecordsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	SelfVitalsRecordsRepo selfVitalsRecordsRepo;


	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
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


		if (bloodPressure < 90 || bloodPressure < 60) {
			return "Low Blood Pressure";
		} else if (bloodPressure > 140 || bloodPressure > 90) {
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


}










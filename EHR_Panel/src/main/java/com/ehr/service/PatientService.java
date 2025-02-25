package com.ehr.service;


import java.util.List;
import java.util.Optional;


import com.ehr.entity.*;
import jakarta.validation.constraints.NotNull;


public interface PatientService {


	Patient savePatient(Patient patient);

	Doctor saveDoctor(Doctor doctor);




	SelfVitalsRecords selfVitalsRecords(SelfVitalsRecords selfVitalsRecords);

	List<Doctor> findAll();

	List<Doctor> findByDoctorId(Long doctorId);

	List<Patient> getAllPatients();

	List<Patient> findByPatientId(Long patientId);


	Prescription savePrescription(Prescription prescription);



	List<String> getSchedulesForPatient(@NotNull Long patientId);

	Appointment saveAppointment(Appointment appointment);

	List<Appointment> getAllAppointments();

	Optional<Appointment> getAppointmentById(String appointmentId);
}

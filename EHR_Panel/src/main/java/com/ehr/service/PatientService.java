package com.ehr.service;


import java.util.List;
import java.util.Optional;


import com.ehr.entity.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PathVariable;


public interface PatientService {


    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    List<Patient> findByPatientId(Long patientId);
    boolean deletedPatientById(@PathVariable @NotNull Long patientId);
    Patient updatePatientById(Long patientId, Patient updatedPatient);
    boolean isPatientExists(Long patientId);
    public boolean existsByPatientId(Long patientId) ;


    Doctor saveDoctor(Doctor doctor);
    boolean deleteDoctorById(Long doctorId);
    Doctor updateDoctorById(Long doctorId, Doctor updatedDoctor);
    List<Doctor> findAll();
    List<Doctor> findByDoctorId(Long doctorId);
    boolean isDoctorExists(String doctorId);



    List<SelfVitalsRecords> getAllSelfVitalsRecords();
    SelfVitalsRecords selfVitalsRecords(SelfVitalsRecords selfVitalsRecords);
    boolean deleteSelfVitalsByPatientId(Long patientId);
    Optional<SelfVitalsRecords> getSelfVitalRecordsByPatientId(Long patientId);
    SelfVitalsRecords updateSelfVitalsByPatientId(Long patientId, SelfVitalsRecords updatedVitals);


    Prescription savePrescription(Prescription prescription);
    boolean deletePrescription(@NotNull Long patientId);
    Prescription updatePrescription(Long patientId, Prescription updatedPrescription);
    List<String> getSchedulesForPatient(@NotNull Long patientId);


    Appointment saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointmentById(Long appointmentId);
    boolean deleteAppointment(Long appointmentId);
    Appointment updateAppointment(Long appointmentId, Appointment updatedAppointment);
}
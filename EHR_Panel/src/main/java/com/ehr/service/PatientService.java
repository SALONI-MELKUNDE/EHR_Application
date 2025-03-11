package com.ehr.service;


import java.util.List;
import java.util.Optional;


import com.ehr.entity.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PathVariable;


public interface PatientService {


    Patient savePatient(Patient patient);

    Doctor saveDoctor(Doctor doctor);


    boolean deletedPatientById(@PathVariable @NotNull Long patientId);
    boolean deleteDoctorById(Long doctorId);

    Doctor updateDoctorById(Long doctorId, Doctor updatedDoctor);
    Patient updatePatientById(Long patientId, Patient updatedPatient);

    SelfVitalsRecords selfVitalsRecords(SelfVitalsRecords selfVitalsRecords);

    List<Doctor> findAll();

    List<Doctor> findByDoctorId(Long doctorId);

    List<Patient> getAllPatients();

    List<Patient> findByPatientId(Long patientId);


    Prescription savePrescription(Prescription prescription);



    List<String> getSchedulesForPatient(@NotNull Long patientId);

    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAllAppointments();

    Optional<Appointment> getAppointmentById(Long appointmentId);

    boolean isPatientExists(Long patientId);

    List<SelfVitalsRecords> getAllSelfVitalsRecords();



    Optional<SelfVitalsRecords> getSelfVitalRecordsByPatientId(Long patientId);

    boolean deleteAppointment(Long appointmentId);

    Appointment updateAppointment(Long appointmentId, Appointment updatedAppointment);



    boolean deletePrescription(@NotNull Long patientId);

    Prescription updatePrescription(Long patientId, Prescription updatedPrescription);

    SelfVitalsRecords updateSelfVitalsByPatientId(Long patientId, SelfVitalsRecords updatedVitals);

    boolean deleteSelfVitalsByPatientId(Long patientId);

    public boolean existsByPatientId(Long patientId) ;


    boolean isDoctorExists(String doctorId);
}
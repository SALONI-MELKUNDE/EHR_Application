//package com.ehr.service;
//
//
//import com.ehr.entity.*;
//import com.ehr.repo.*;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//
//@Service
//public class PatientServiceImpl implements PatientService {
//
//    @Autowired
//    DoctorRepository doctorRepository;
//
//    @Autowired
//    PatientRepository patientRepository;
//
//    @Autowired
//    SelfVitalsRecordsRepo selfVitalsRecordsRepo;
//
//
//    @Autowired
//    PrescriptionRepository prescriptionRepository;
//
//    @Autowired
//    AppointmentRepository appointmentRepository;
//
//
//    @Override
//    public Patient savePatient(Patient patient) {return patientRepository.save(patient);}
//
//    @Override
//    public Doctor saveDoctor(Doctor doctor) {
//        return doctorRepository.save(doctor);
//    }
//
//    @Override
//    public boolean deletedPatientById(Long patientId) {
//        if (patientRepository.existsById(patientId)) {
//            patientRepository.deleteById(patientId);
//            return true; // Successfully deleted
//        }
//        return false; // Patient ID not found
//    }
//
//    @Override
//    public boolean deleteDoctorById(Long doctorId) {
//        if (doctorRepository.existsById(doctorId)) {
//            doctorRepository.deleteById(doctorId);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Doctor updateDoctorById(Long doctorId, Doctor updatedDoctor) {
//        Optional<Doctor> existingDoctorOpt = doctorRepository.findById(doctorId);
//
//        if (existingDoctorOpt.isPresent()) {
//            Doctor existingDoctor = existingDoctorOpt.get();
//
//            // Updating only non-null fields
//            if (updatedDoctor.getDoctorName() != null) {
//                existingDoctor.setDoctorName(updatedDoctor.getDoctorName());
//            }
//            if (updatedDoctor.getDoctorGender() != null) {
//                existingDoctor.setDoctorGender(updatedDoctor.getDoctorGender());
//            }
//            if (updatedDoctor.getPurposeOfVisit() != null) {
//                existingDoctor.setPurposeOfVisit(updatedDoctor.getPurposeOfVisit());
//            }
//            if (updatedDoctor.getDiagnosisRecommendation() != null) {
//                existingDoctor.setDiagnosisRecommendation(updatedDoctor.getDiagnosisRecommendation());
//            }
//            if (updatedDoctor.getDoctorPhone() != null) {
//                existingDoctor.setDoctorPhone(updatedDoctor.getDoctorPhone());
//            }
//            if (updatedDoctor.getDoctorEmail() != null) {
//                existingDoctor.setDoctorEmail(updatedDoctor.getDoctorEmail());
//            }
//            if (updatedDoctor.getSelfAge() > 0) {
//                existingDoctor.setSelfAge(updatedDoctor.getSelfAge());
//            }
//            if (updatedDoctor.getDateOfVisit() != null) {
//                existingDoctor.setDateOfVisit(updatedDoctor.getDateOfVisit());
//            }
//            if (updatedDoctor.getSelfMedicalDocs() != null) {
//                existingDoctor.setSelfMedicalDocs(updatedDoctor.getSelfMedicalDocs());
//            }
//
//            // Save updated doctor details
//            return doctorRepository.save(existingDoctor);
//        } else {
//            return null; // No doctor found
//        }
//    }
//
//
//    @Override
//    public Patient updatePatientById(Long patientId, Patient updatedPatient) {
//        Optional<Patient> existingPatient = patientRepository.findById(patientId);
//
//        if (existingPatient.isPresent()) {
//            Patient patient = existingPatient.get();
//            patient.setPatientName(updatedPatient.getPatientName());
//            patient.setPatientAge(updatedPatient.getPatientAge());
//            patient.setPatientGender(updatedPatient.getPatientGender());
//            patient.setPurposeOfVisit(updatedPatient.getPurposeOfVisit());
//            patient.setDiagnosisRecommendation(updatedPatient.getDiagnosisRecommendation());
//            patient.setPatientPhone(updatedPatient.getPatientPhone());
//            patient.setPatientEmail(updatedPatient.getPatientEmail());
//            patient.setPatientDateOfVisit(updatedPatient.getPatientDateOfVisit());
//            patient.setPatientMedicalDocs(updatedPatient.getPatientMedicalDocs());
//
//            return patientRepository.save(patient); // Save and return updated patient
//        }
//        return null; // If not found, return null
//    }
//
//
//    public SelfVitalsRecords selfVitalsRecords(SelfVitalsRecords selfVitalsRecords) {
//        // Evaluating each vital and setting the status
//        selfVitalsRecords.setHeartRateStatus(evaluateHeartRate(selfVitalsRecords.getHeartRate()));
//        selfVitalsRecords.setBloodPressureStatus(evaluateBloodPressure(selfVitalsRecords.getBloodPressure()));
//        selfVitalsRecords.setRespiratoryRateStatus(evaluateRespiratoryRate(selfVitalsRecords.getRespiratoryRate()));
//        selfVitalsRecords.setBodyTemperatureStatus(evaluateBodyTemperature(selfVitalsRecords.getBodyTemperature()));
//        selfVitalsRecords.setBloodGlucoseStatus(evaluateBloodGlucose(selfVitalsRecords.getBloodGlucose()));
//        selfVitalsRecords.setOxygenSaturationStatus(evaluateOxygenSaturation(selfVitalsRecords.getOxygenSaturation()));
//
//        // Saving the evaluated vitals in the database
//        return selfVitalsRecordsRepo.save(selfVitalsRecords);
//    }
//
//    // Logic to evaluate Heart Rate status
//    private String evaluateHeartRate(int heartRate) {
//        if (heartRate < 40) {
//            return "Low Heart Rate";
//        } else if (heartRate > 130) {
//            return "High Heart Rate";
//        } else {
//            return "Normal Range";
//        }
//    }
//
//    // Logic to evaluate Blood Pressure status
//    private String evaluateBloodPressure(int bloodPressure) {
//
//
//        if (bloodPressure < 90) {
//            return "Low Blood Pressure";
//        } else if (bloodPressure > 90) {
//            return "High Blood Pressure";
//        } else {
//            return "Normal Range";
//        }
//    }
//
//    // Logic to evaluate Respiratory Rate status
//    private String evaluateRespiratoryRate(int respiratoryRate) {
//        if (respiratoryRate < 8) {
//            return "Low Respiratory Rate";
//        } else if (respiratoryRate > 30) {
//            return "High Respiratory Rate";
//        } else {
//            return "Normal Range";
//        }
//    }
//
//    // Logic to evaluate Body Temperature status
//    private String evaluateBodyTemperature(double bodyTemperature) {
//        if (bodyTemperature < 95) {
//            return "Low Body Temperature";
//        } else if (bodyTemperature > 100) {
//            return "High Body Temperature";
//        } else {
//            return "Normal Range";
//        }
//    }
//
//    // Logic to evaluate Blood Glucose status
//    private String evaluateBloodGlucose(double bloodGlucose) {
//        if (bloodGlucose < 60) {
//            return "Low Blood Glucose";
//        } else if (bloodGlucose > 126) {
//            return "High Blood Glucose";
//        } else {
//            return "Normal Range";
//        }
//    }
//
//    // Logic to evaluate Oxygen Saturation status
//    private String evaluateOxygenSaturation(double oxygenSaturation) {
//        if (oxygenSaturation < 88) {
//            return "Low Oxygen Saturation";
//        } else if (oxygenSaturation > 92) {
//            return "High Oxygen Saturation";
//        } else {
//            return "Normal Range";
//        }
//    }
//
//
//    @Override
//    public List<Doctor> findAll() {
//
//        return doctorRepository.findAll();
//    }
//
//
//    @Override
//    public List<Doctor> findByDoctorId(Long doctorId) {
//
//        return doctorRepository.findByDoctorId(doctorId);
//    }
//
//
//    public List<Patient> getAllPatients() {
//
//        return patientRepository.findAll();
//    }
//
//
//    public List<Patient> findByPatientId(Long patientId) {
//
//        return patientRepository.findByPatientId(patientId);
//    }
//
//    @Override
//    public Prescription savePrescription(Prescription prescription) {
//
//        int timesPerDay = prescription.getPrescriptionRecommendedXTimesPerDay();
//
//        if (timesPerDay >= 1) {
//            prescription.setMorningSlot("8:00 AM - 11:00 AM"); // Morning Slot
//        }
//
//        if (timesPerDay >= 2) {
//            prescription.setAfternoonSlot("12:00 PM - 3:00 PM"); // Afternoon Slot
//        }
//
//        if (timesPerDay == 3) {
//            prescription.setEveningSlot("6:00 PM - 9:00 PM"); // Evening Slot
//        }
//        return prescriptionRepository.save(prescription);
//    }
//
//
//    public List<String> getSchedulesForPatient(Long patientId) {
//        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);
//
//        List<String> schedules = new ArrayList<>();
//
//        if (prescriptions.isEmpty()) {
//            return schedules; // No prescriptions found for the patient
//        }
//
//        for (Prescription prescription : prescriptions) {
//            StringBuilder schedule = new StringBuilder();
//
//            // Start with the medicine name
//            schedule.append("Medicine: ").append(prescription.getMedicineName()).append("\n");
//
//            // Add time slots if they are not null
//            if (prescription.getMorningSlot() != null) {
//                schedule.append("Morning: ").append(prescription.getMorningSlot()).append("\n");
//            }
//
//            if (prescription.getAfternoonSlot() != null) {
//                schedule.append("Afternoon: ").append(prescription.getAfternoonSlot()).append("\n");
//            }
//
//            if (prescription.getEveningSlot() != null) {
//                schedule.append("Evening: ").append(prescription.getEveningSlot()).append("\n");
//            }
//
//            schedules.add(schedule.toString().trim()); // Add the schedule for this prescription to the list
//        }
//
//        return schedules;
//    }
//
//
//    // ✅ Save appointment
//    public Appointment saveAppointment(Appointment appointment) {
//        return appointmentRepository.save(appointment);
//    }
//
//    // ✅ Get all appointments
//    public List<Appointment> getAllAppointments() {
//        return appointmentRepository.findAll();
//    }
//
//    // ✅ Get an appointment by ID
//    public Optional<Appointment> getAppointmentById(Long appointmentId) {
//        return appointmentRepository.findById(appointmentId);
//    }
//
//    @Override
//    public boolean isPatientExists(Long patientId) {
//        return patientRepository.existsById(Long.valueOf(patientId));
//    }
//
//    @Override
//    public List<SelfVitalsRecords> getAllSelfVitalsRecords() {
//        return selfVitalsRecordsRepo.findAll();
//    }
//
//
//    public Optional<SelfVitalsRecords> getSelfVitalRecordsByPatientId(Long patientId) {
//        return selfVitalsRecordsRepo.findByPatientId(patientId); // Match repo method
//    }
//
//
//    public boolean deleteAppointment(Long appointmentId) {
//        if (appointmentRepository.existsById(appointmentId)) {
//            appointmentRepository.deleteById(appointmentId);
//            return true;
//        }
//        return false;
//    }
//
//    public Appointment updateAppointment(Long appointmentId, Appointment updatedAppointment) {
//        return appointmentRepository.findById(appointmentId)
//                .map(existingAppointment -> {
//                    System.out.println("Updating appointment ID: " + appointmentId);
//
//                    existingAppointment.setDoctor_id(updatedAppointment.getDoctor_id());
//                    existingAppointment.setPatient_id(updatedAppointment.getPatient_id());
//                    existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
//                    existingAppointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
//                    existingAppointment.setAppointmentStatus(updatedAppointment.getAppointmentStatus());
//                    existingAppointment.setReasonForVisit(updatedAppointment.getReasonForVisit());
//                    existingAppointment.setAdditionalNotes(updatedAppointment.getAdditionalNotes());
//
//                    return appointmentRepository.save(existingAppointment);
//                }).orElseGet(() -> {
//                    System.out.println("Appointment not found with ID: " + appointmentId);
//                    return null;
//                });
//    }
//
//
//    @Override
//    public boolean deletePrescription(Long patientId) {
//
//        if (prescriptionRepository.existsById(patientId)) {
//            prescriptionRepository.deleteById(patientId);
//            return true;
//        }
//        return false;
//
//
//    }
//
//
//
//    public Prescription updatePrescription(Long prescriptionId, Prescription updatedPrescription) {
//        return prescriptionRepository.findById(prescriptionId)
//                .map(existingPrescription -> {
//                    System.out.println("Updating prescription with ID: " + prescriptionId);
//
//                    existingPrescription.setPatientName(updatedPrescription.getPatientName());
//                    existingPrescription.setMedicineName(updatedPrescription.getMedicineName());
//                    existingPrescription.setPrescriptionStartDate(updatedPrescription.getPrescriptionStartDate());
//                    existingPrescription.setPrescriptionEndDate(updatedPrescription.getPrescriptionEndDate());
//                    existingPrescription.setPrescriptionRecommendedXTimesPerDay(updatedPrescription.getPrescriptionRecommendedXTimesPerDay());
//                    existingPrescription.setMorningSlot(updatedPrescription.getMorningSlot());
//                    existingPrescription.setAfternoonSlot(updatedPrescription.getAfternoonSlot());
//                    existingPrescription.setEveningSlot(updatedPrescription.getEveningSlot());
//
//                    return prescriptionRepository.save(existingPrescription);
//                })
//                .orElseThrow(() -> new NoSuchElementException("Prescription not found with ID: " + prescriptionId));
//    }
//
//
//
//
//
//
//
//
//    // Update based on patientId
//    public SelfVitalsRecords updateSelfVitalsByPatientId(Long patientId, SelfVitalsRecords updatedVitals) {
//        return selfVitalsRecordsRepo.findByPatientId(patientId)
//                .map(existingVitals -> {
//                    System.out.println("Updating Self Vitals Record for patient ID: " + patientId);
//
//                    existingVitals.setName(updatedVitals.getName());
//                    existingVitals.setAge(updatedVitals.getAge());
//                    existingVitals.setGender(updatedVitals.getGender());
//                    existingVitals.setWeight(updatedVitals.getWeight());
//                    existingVitals.setHeight(updatedVitals.getHeight());
//                    existingVitals.setBloodType(updatedVitals.getBloodType());
//                    existingVitals.setHeartRate(updatedVitals.getHeartRate());
//                    existingVitals.setBloodPressure(updatedVitals.getBloodPressure());
//                    existingVitals.setRespiratoryRate(updatedVitals.getRespiratoryRate());
//                    existingVitals.setBodyTemperature(updatedVitals.getBodyTemperature());
//                    existingVitals.setBloodGlucose(updatedVitals.getBloodGlucose());
//                    existingVitals.setOxygenSaturation(updatedVitals.getOxygenSaturation());
//                    existingVitals.setHeartRateStatus(updatedVitals.getHeartRateStatus());
//                    existingVitals.setBloodPressureStatus(updatedVitals.getBloodPressureStatus());
//                    existingVitals.setRespiratoryRateStatus(updatedVitals.getRespiratoryRateStatus());
//                    existingVitals.setBodyTemperatureStatus(updatedVitals.getBodyTemperatureStatus());
//                    existingVitals.setBloodGlucoseStatus(updatedVitals.getBloodGlucoseStatus());
//                    existingVitals.setOxygenSaturationStatus(updatedVitals.getOxygenSaturationStatus());
//
//                    return selfVitalsRecordsRepo.save(existingVitals);
//                })
//                .orElseThrow(() -> new NoSuchElementException("Self Vitals Record not found for patient ID: " + patientId));
//    }
//
//    // Delete based on patientId
//    @Transactional
//    public boolean deleteSelfVitalsByPatientId(Long patientId) {
//        Optional<SelfVitalsRecords> record = selfVitalsRecordsRepo.findByPatientId(patientId);
//        if (record.isPresent()) {
//            selfVitalsRecordsRepo.deleteByPatientId(patientId);
//            System.out.println("Deleted Self Vitals Record for patient ID: " + patientId);
//            return true;
//        } else {
//            System.out.println("Self Vitals Record not found for patient ID: " + patientId);
//            return false;
//        }
//    }
//
//    @Override
//    public boolean existsByPatientId(Long patientId) {
//        return patientRepository.existsById(patientId);
//    }
//
//    @Override
//    public boolean isDoctorExists(String doctorId) {
//        return doctorRepository.existsById(Long.valueOf(doctorId));
//    }
//}
//
//
//




package com.ehr.service;

import com.ehr.entity.*;
import com.ehr.repo.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

            return patientRepository.save(patient);
        }
        return null;
    }

    public SelfVitalsRecords selfVitalsRecords(SelfVitalsRecords selfVitalsRecords) {

        selfVitalsRecords.setHeartRateStatus(evaluateHeartRate(selfVitalsRecords.getHeartRate()));
        selfVitalsRecords.setBloodPressureStatus(evaluateBloodPressure(selfVitalsRecords.getBloodPressure()));
        selfVitalsRecords.setRespiratoryRateStatus(evaluateRespiratoryRate(selfVitalsRecords.getRespiratoryRate()));
        selfVitalsRecords.setBodyTemperatureStatus(evaluateBodyTemperature(selfVitalsRecords.getBodyTemperature()));
        selfVitalsRecords.setBloodGlucoseStatus(evaluateBloodGlucose(selfVitalsRecords.getBloodGlucose()));
        selfVitalsRecords.setOxygenSaturationStatus(evaluateOxygenSaturation(selfVitalsRecords.getOxygenSaturation()));


        return selfVitalsRecordsRepo.save(selfVitalsRecords);
    }


    private String evaluateHeartRate(int heartRate) {
        if (heartRate < 40) {
            return "Low Heart Rate";
        } else if (heartRate > 130) {
            return "High Heart Rate";
        } else {
            return "Normal Range";
        }
    }


    private String evaluateBloodPressure(int bloodPressure) {
        if (bloodPressure < 90) {
            return "Low Blood Pressure";
        } else if (bloodPressure > 140) {
            return "High Blood Pressure";
        } else {
            return "Normal Range";
        }
    }


    private String evaluateRespiratoryRate(int respiratoryRate) {
        if (respiratoryRate < 8) {
            return "Low Respiratory Rate";
        } else if (respiratoryRate > 30) {
            return "High Respiratory Rate";
        } else {
            return "Normal Range";
        }
    }


    private String evaluateBodyTemperature(double bodyTemperature) {
        if (bodyTemperature < 95) {
            return "Low Body Temperature";
        } else if (bodyTemperature > 100) {
            return "High Body Temperature";
        } else {
            return "Normal Range";
        }
    }


    private String evaluateBloodGlucose(double bloodGlucose) {
        if (bloodGlucose < 60) {
            return "Low Blood Glucose";
        } else if (bloodGlucose > 126) {
            return "High Blood Glucose";
        } else {
            return "Normal Range";
        }
    }


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
            return schedules;
        }

        for (Prescription prescription : prescriptions) {
            StringBuilder schedule = new StringBuilder();

            schedule.append("Medicine: ").append(prescription.getMedicineName()).append("\n");


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
    public Optional<Appointment> getAppointmentById(Long appointmentId) {
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

    public Optional<SelfVitalsRecords> getSelfVitalRecordsByPatientId(Long patientId) {
        return selfVitalsRecordsRepo.findByPatientId(patientId); // Match repo method
    }

    public boolean deleteAppointment(Long appointmentId) {
        if (appointmentRepository.existsById(appointmentId)) {
            appointmentRepository.deleteById(appointmentId);
            return true;
        }
        return false;
    }

    public Appointment updateAppointment(Long appointmentId, Appointment updatedAppointment) {
        return appointmentRepository.findById(appointmentId)
                .map(existingAppointment -> {
                    System.out.println("Updating appointment ID: " + appointmentId);
                    existingAppointment.setDoctor_id(updatedAppointment.getDoctor_id());
                    existingAppointment.setPatient_id(updatedAppointment.getPatient_id());
                    existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
                    existingAppointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
                    existingAppointment.setAppointmentStatus(updatedAppointment.getAppointmentStatus());
                    existingAppointment.setReasonForVisit(updatedAppointment.getReasonForVisit());
                    existingAppointment.setAdditionalNotes(updatedAppointment.getAdditionalNotes());
                    return appointmentRepository.save(existingAppointment);
                }).orElseGet(() -> {
                    System.out.println("Appointment not found with ID: " + appointmentId);
                    return null;
                });
    }

    @Override
    public boolean deletePrescription(Long patientId) {
        if (prescriptionRepository.existsById(patientId)) {
            prescriptionRepository.deleteById(patientId);
            return true;
        }
        return false;
    }

    public Prescription updatePrescription(Long patientId, Prescription updatedPrescription) {

        List<Prescription> prescriptions = prescriptionRepository.findByPatientId(patientId);
        Prescription existingPrescription = prescriptions.stream()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Prescription not found for Patient ID: " + patientId));

        System.out.println("Updating prescription for Patient ID: " + patientId);


        existingPrescription.setPatientName(updatedPrescription.getPatientName());
        existingPrescription.setMedicineName(updatedPrescription.getMedicineName());
        existingPrescription.setPrescriptionStartDate(updatedPrescription.getPrescriptionStartDate());
        existingPrescription.setPrescriptionEndDate(updatedPrescription.getPrescriptionEndDate());
        existingPrescription.setPrescriptionRecommendedXTimesPerDay(updatedPrescription.getPrescriptionRecommendedXTimesPerDay());
        existingPrescription.setMorningSlot(updatedPrescription.getMorningSlot());
        existingPrescription.setAfternoonSlot(updatedPrescription.getAfternoonSlot());
        existingPrescription.setEveningSlot(updatedPrescription.getEveningSlot());

        return prescriptionRepository.save(existingPrescription);
    }


    public SelfVitalsRecords updateSelfVitalsByPatientId(Long patientId, SelfVitalsRecords updatedVitals) {
        return selfVitalsRecordsRepo.findByPatientId(patientId)
                .map(existingVitals -> {
                    System.out.println("Updating Self Vitals Record for patient ID: " + patientId);
                    existingVitals.setName(updatedVitals.getName());
                    existingVitals.setAge(updatedVitals.getAge());
                    existingVitals.setGender(updatedVitals.getGender());
                    existingVitals.setWeight(updatedVitals.getWeight());
                    existingVitals.setHeight(updatedVitals.getHeight());
                    existingVitals.setBloodType(updatedVitals.getBloodType());
                    existingVitals.setHeartRate(updatedVitals.getHeartRate());
                    existingVitals.setBloodPressure(updatedVitals.getBloodPressure());
                    existingVitals.setRespiratoryRate(updatedVitals.getRespiratoryRate());
                    existingVitals.setBodyTemperature(updatedVitals.getBodyTemperature());
                    existingVitals.setBloodGlucose(updatedVitals.getBloodGlucose());
                    existingVitals.setOxygenSaturation(updatedVitals.getOxygenSaturation());
                    existingVitals.setHeartRateStatus(updatedVitals.getHeartRateStatus());
                    existingVitals.setBloodPressureStatus(updatedVitals.getBloodPressureStatus());
                    existingVitals.setRespiratoryRateStatus(updatedVitals.getRespiratoryRateStatus());
                    existingVitals.setBodyTemperatureStatus(updatedVitals.getBodyTemperatureStatus());
                    existingVitals.setBloodGlucoseStatus(updatedVitals.getBloodGlucoseStatus());
                    existingVitals.setOxygenSaturationStatus(updatedVitals.getOxygenSaturationStatus());
                    return selfVitalsRecordsRepo.save(existingVitals);
                })
                .orElseThrow(() -> new NoSuchElementException("Self Vitals Record not found for patient ID: " + patientId));
    }


    @Transactional
    public boolean deleteSelfVitalsByPatientId(Long patientId) {
        Optional<SelfVitalsRecords> record = selfVitalsRecordsRepo.findByPatientId(patientId);
        if (record.isPresent()) {
            selfVitalsRecordsRepo.deleteByPatientId(patientId);
            System.out.println("Deleted Self Vitals Record for patient ID: " + patientId);
            return true;
        } else {
            System.out.println("Self Vitals Record not found for patient ID: " + patientId);
            return false;
        }
    }

    @Override
    public boolean existsByPatientId(Long patientId) {
        return patientRepository.existsById(patientId);
    }

    @Override
    public boolean isDoctorExists(String doctorId) {
        return doctorRepository.existsById(Long.valueOf(doctorId));
    }
}


















































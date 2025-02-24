package com.ehr.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @Column(name = "Appointment_ID", length = 10, nullable = false, unique = true)
    private String appointmentId;

    @ManyToOne
    @JoinColumn(name = "Doctor_ID", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "Patient_ID", nullable = false)
    private Patient patient;

    @Column(name = "Appointment_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Column(name = "Appointment_Time", length = 20, nullable = false)
    private String appointmentTime;

    @Column(name = "Appointment_Status", length = 20, nullable = false)
    private String appointmentStatus;

    @Column(name = "Reason_for_Visit", length = 255, nullable = false)
    private String reasonForVisit;

    @Column(name = "Additional_Notes", columnDefinition = "TEXT")
    private String additionalNotes;

    public Appointment() {

    }


    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", appointmentStatus='" + appointmentStatus + '\'' +
                ", reasonForVisit='" + reasonForVisit + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }

    public Appointment(String appointmentId, Patient patient, Doctor doctor, Date appointmentDate, String appointmentTime, String appointmentStatus, String reasonForVisit, String additionalNotes) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentStatus = appointmentStatus;
        this.reasonForVisit = reasonForVisit;
        this.additionalNotes = additionalNotes;
    }
}

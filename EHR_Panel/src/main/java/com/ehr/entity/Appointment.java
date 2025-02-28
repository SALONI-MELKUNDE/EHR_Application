package com.ehr.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Appointment_ID")
    private Long appointmentId;

    @Column(name = "doctor_id")
    private String doctor;

    @Column(name = "patient_id")
    private String patient_id;


    @Column(name = "Appointment_Date")
    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Column(name = "Appointment_Time")
    private String appointmentTime;

    @Column(name = "Appointment_Status")
    private String appointmentStatus;

    @Column(name = "Reason_for_Visit")
    private String reasonForVisit;

    @Column(name = "Additional_Notes")
    private String additionalNotes;

    public Appointment() {

    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
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

    public Appointment(Long appointmentId, String additionalNotes, String appointmentStatus, String appointmentTime, Date appointmentDate, String patient_id, String doctor, String reasonForVisit) {
        this.appointmentId = appointmentId;
        this.additionalNotes = additionalNotes;
        this.appointmentStatus = appointmentStatus;
        this.appointmentTime = appointmentTime;
        this.appointmentDate = appointmentDate;
        this.patient_id = patient_id;
        this.doctor = doctor;
        this.reasonForVisit = reasonForVisit;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", doctor='" + doctor + '\'' +
                ", patient_id='" + patient_id + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", appointmentStatus='" + appointmentStatus + '\'' +
                ", reasonForVisit='" + reasonForVisit + '\'' +
                ", additionalNotes='" + additionalNotes + '\'' +
                '}';
    }
}

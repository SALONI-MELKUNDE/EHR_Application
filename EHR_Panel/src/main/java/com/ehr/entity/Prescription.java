package com.ehr.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prescriptions_data")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    @Column(name = "Patient_ID")
    private Long patientId;

    @Column(name = "Patient_Name", nullable = false)
    private String patientName;

    @Column(name = "Medicine_Name", nullable = false)
    private String medicineName;

    @Column(name = "Prescription_Start_Date", nullable = false)
    private String prescriptionStartDate;

    @Column(name = "Prescription_End_Date", nullable = false)
    private String prescriptionEndDate;

    @Column(name = "Prescription_Recommended_X_times_per_day", nullable = false)
    private int prescriptionRecommendedXTimesPerDay;

    // Columns for the time slots
    @Column(name = "Morning_Slot")
    private String morningSlot;

    @Column(name = "Afternoon_Slot")
    private String afternoonSlot;

    @Column(name = "Evening_Slot")
    private String eveningSlot;


    public Prescription() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getPrescriptionStartDate() {
        return prescriptionStartDate;
    }

    public void setPrescriptionStartDate(String prescriptionStartDate) {
        this.prescriptionStartDate = prescriptionStartDate;
    }

    public String getPrescriptionEndDate() {
        return prescriptionEndDate;
    }

    public void setPrescriptionEndDate(String prescriptionEndDate) {
        this.prescriptionEndDate = prescriptionEndDate;
    }

    public int getPrescriptionRecommendedXTimesPerDay() {
        return prescriptionRecommendedXTimesPerDay;
    }

    public void setPrescriptionRecommendedXTimesPerDay(int prescriptionRecommendedXTimesPerDay) {
        this.prescriptionRecommendedXTimesPerDay = prescriptionRecommendedXTimesPerDay;
    }

    public String getMorningSlot() {
        return morningSlot;
    }

    public void setMorningSlot(String morningSlot) {
        this.morningSlot = morningSlot;
    }

    public String getAfternoonSlot() {
        return afternoonSlot;
    }

    public void setAfternoonSlot(String afternoonSlot) {
        this.afternoonSlot = afternoonSlot;
    }

    public String getEveningSlot() {
        return eveningSlot;
    }

    public void setEveningSlot(String eveningSlot) {
        this.eveningSlot = eveningSlot;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "Id=" + Id +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", prescriptionStartDate='" + prescriptionStartDate + '\'' +
                ", prescriptionEndDate='" + prescriptionEndDate + '\'' +
                ", prescriptionRecommendedXTimesPerDay=" + prescriptionRecommendedXTimesPerDay +
                ", morningSlot='" + morningSlot + '\'' +
                ", afternoonSlot='" + afternoonSlot + '\'' +
                ", eveningSlot='" + eveningSlot + '\'' +
                '}';
    }
}
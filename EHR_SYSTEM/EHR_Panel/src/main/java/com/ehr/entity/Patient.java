package com.ehr.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Patient_Details_Data")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_ID")
    private Long patientId;

    @Column(name = "PATIENT_NAME")
    private String patientName;

    @Column(name = "PATIENT_AGE")
    private Integer patientAge;

    @Column(name = "PATIENT_GENDER")
    private String patientGender;

    @Column(name = "PURPOSE_OF_VISIT")
    private String purposeOfVisit;

    @Column(name = "DIAGNOSIS_RECOMMENDATION")
    private String diagnosisRecommendation;

    @Column(name = "PATIENT_PHONE")
    private String patientPhone;

    @Column(name = "PATIENT_EMAIL")
    private String patientEmail;

    @Temporal(TemporalType.DATE)
    @Column(name = "PATIENT_DATE_OF_VISIT")
    private Date patientDateOfVisit;

    @Column(name = "PATIENT_MEDICAL_DOCS")
    private String patientMedicalDocs; // Assuming this is a file path or document link

    // Getters and Setters
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

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }



    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public String getDiagnosisRecommendation() {
        return diagnosisRecommendation;
    }

    public void setDiagnosisRecommendation(String diagnosisRecommendation) {
        this.diagnosisRecommendation = diagnosisRecommendation;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public Date getPatientDateOfVisit() {
        return patientDateOfVisit;
    }

    public void setPatientDateOfVisit(Date patientDateOfVisit) {
        this.patientDateOfVisit = patientDateOfVisit;
    }

    public String getPatientMedicalDocs() {
        return patientMedicalDocs;
    }

    public void setPatientMedicalDocs(String patientMedicalDocs) {
        this.patientMedicalDocs = patientMedicalDocs;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
                + ", patientGender=" + patientGender + ", purposeOfVisit=" + purposeOfVisit
                + ", diagnosisRecommendation=" + diagnosisRecommendation + ", patientPhone=" + patientPhone
                + ", patientEmail=" + patientEmail + ", patientDateOfVisit=" + patientDateOfVisit
                + ", patientMedicalDocs=" + patientMedicalDocs + "]";
    }

    public Patient(Long patientId, String patientName, Integer patientAge, String patientGender, String purposeOfVisit,
                   String diagnosisRecommendation, String patientPhone, String patientEmail, Date patientDateOfVisit,
                   String patientMedicalDocs) {
        super();
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.purposeOfVisit = purposeOfVisit;
        this.diagnosisRecommendation = diagnosisRecommendation;
        this.patientPhone = patientPhone;
        this.patientEmail = patientEmail;
        this.patientDateOfVisit = patientDateOfVisit;
        this.patientMedicalDocs = patientMedicalDocs;
    }

    public Patient() {
        // Default constructor body (if needed)
    }


}

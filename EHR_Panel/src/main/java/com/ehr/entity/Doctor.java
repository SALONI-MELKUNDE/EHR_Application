package com.ehr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Doctor_Record")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Enables auto-increment
	@Column(name = "doctor_id")
	private Long doctorId;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "doctor_gender")
	private String doctorGender;

	@Column(name = "purpose_of_visit")
	private String purposeOfVisit;

	@Column(name = "diagnosis_recommendation")
	private String diagnosisRecommendation;

	@Column(name = "doctor_phone")
	private String doctorPhone;

	@Column(name = "doctor_email")
	private String doctorEmail;

	@Column(name = "self_age")
	private int selfAge;

	@Column(name = "date_of_visit")
	private String dateOfVisit;

	@Column(name = "self_medical_docs")
	private String selfMedicalDocs;

	public Doctor()
	{

	}


	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorGender() {
		return doctorGender;
	}
	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
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
	public String getDoctorPhone() {
		return doctorPhone;
	}
	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public int getSelfAge() {
		return selfAge;
	}
	public void setSelfAge(int selfAge) {
		this.selfAge = selfAge;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}
	public String getSelfMedicalDocs() {
		return selfMedicalDocs;
	}
	public void setSelfMedicalDocs(String selfMedicalDocs) {
		this.selfMedicalDocs = selfMedicalDocs;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorGender=" + doctorGender
				+ ", purposeOfVisit=" + purposeOfVisit + ", diagnosisRecommendation=" + diagnosisRecommendation
				+ ", doctorPhone=" + doctorPhone + ", doctorEmail=" + doctorEmail + ", selfAge=" + selfAge
				+ ", dateOfVisit=" + dateOfVisit + ", selfMedicalDocs=" + selfMedicalDocs + "]";
	}
	public Doctor(Long doctorId, String doctorName, String doctorGender, String purposeOfVisit,
				  String diagnosisRecommendation, String doctorPhone, String doctorEmail, int selfAge, String dateOfVisit,
				  String selfMedicalDocs) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorGender = doctorGender;
		this.purposeOfVisit = purposeOfVisit;
		this.diagnosisRecommendation = diagnosisRecommendation;
		this.doctorPhone = doctorPhone;
		this.doctorEmail = doctorEmail;
		this.selfAge = selfAge;
		this.dateOfVisit = dateOfVisit;
		this.selfMedicalDocs = selfMedicalDocs;
	}





}

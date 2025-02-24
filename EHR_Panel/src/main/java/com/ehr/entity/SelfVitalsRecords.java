package com.ehr.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SELF_VITALS_RECORDs_Data")
public class SelfVitalsRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "WEIGHT")
    private double weight;

    @Column(name = "HEIGHT")
    private double height;

    @Column(name = "BLOOD_TYPE")
    private String bloodType;

    @Column(name = "HEART_RATE")
    private int heartRate;

    @Column(name = "BLOOD_PRESSURE")
    private int bloodPressure; // Format: "systolic/diastolic"

    @Column(name = "RESPIRATORY_RATE")
    private int respiratoryRate;

    @Column(name = "BODY_TEMPERATURE")
    private double bodyTemperature;

    @Column(name = "BLOOD_GLUCOSE")
    private double bloodGlucose;

    @Column(name = "OXYGEN_SATURATION")
    private double oxygenSaturation;

    // Health Status Columns
    @Column(name = "HEART_RATE_STATUS")
    private String heartRateStatus;

    @Column(name = "BLOOD_PRESSURE_STATUS")
    private String bloodPressureStatus;

    @Column(name = "RESPIRATORY_RATE_STATUS")
    private String respiratoryRateStatus;

    @Column(name = "BODY_TEMPERATURE_STATUS")
    private String bodyTemperatureStatus;

    @Column(name = "BLOOD_GLUCOSE_STATUS")
    private String bloodGlucoseStatus;

    @Column(name = "OXYGEN_SATURATION_STATUS")
    private String oxygenSaturationStatus;

    // Relationship with Patient
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID") // Foreign key to Patient table
    private Patient patient;

    public SelfVitalsRecords() {

    }


    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public double getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(double bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(double oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public String getHeartRateStatus() {
        return heartRateStatus;
    }

    public void setHeartRateStatus(String heartRateStatus) {
        this.heartRateStatus = heartRateStatus;
    }

    public String getBloodPressureStatus() {
        return bloodPressureStatus;
    }

    public void setBloodPressureStatus(String bloodPressureStatus) {
        this.bloodPressureStatus = bloodPressureStatus;
    }

    public String getRespiratoryRateStatus() {
        return respiratoryRateStatus;
    }

    public void setRespiratoryRateStatus(String respiratoryRateStatus) {
        this.respiratoryRateStatus = respiratoryRateStatus;
    }

    public String getBodyTemperatureStatus() {
        return bodyTemperatureStatus;
    }

    public void setBodyTemperatureStatus(String bodyTemperatureStatus) {
        this.bodyTemperatureStatus = bodyTemperatureStatus;
    }

    public String getBloodGlucoseStatus() {
        return bloodGlucoseStatus;
    }

    public void setBloodGlucoseStatus(String bloodGlucoseStatus) {
        this.bloodGlucoseStatus = bloodGlucoseStatus;
    }

    public String getOxygenSaturationStatus() {
        return oxygenSaturationStatus;
    }

    public void setOxygenSaturationStatus(String oxygenSaturationStatus) {
        this.oxygenSaturationStatus = oxygenSaturationStatus;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "SelfVitalsRecords [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", weight="
                + weight + ", height=" + height + ", bloodType=" + bloodType + ", heartRate=" + heartRate
                + ", bloodPressure=" + bloodPressure + ", respiratoryRate=" + respiratoryRate + ", bodyTemperature="
                + bodyTemperature + ", bloodGlucose=" + bloodGlucose + ", oxygenSaturation=" + oxygenSaturation
                + ", heartRateStatus=" + heartRateStatus + ", bloodPressureStatus=" + bloodPressureStatus
                + ", respiratoryRateStatus=" + respiratoryRateStatus + ", bodyTemperatureStatus="
                + bodyTemperatureStatus + ", bloodGlucoseStatus=" + bloodGlucoseStatus + ", oxygenSaturationStatus="
                + oxygenSaturationStatus + "]";
    }

    public SelfVitalsRecords(Long id, String name, int age, String gender, double weight, double height,
                             String bloodType, int heartRate, int bloodPressure, int respiratoryRate, double bodyTemperature,
                             double bloodGlucose, double oxygenSaturation, String heartRateStatus, String bloodPressureStatus,
                             String respiratoryRateStatus, String bodyTemperatureStatus, String bloodGlucoseStatus,
                             String oxygenSaturationStatus) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.bloodType = bloodType;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.respiratoryRate = respiratoryRate;
        this.bodyTemperature = bodyTemperature;
        this.bloodGlucose = bloodGlucose;
        this.oxygenSaturation = oxygenSaturation;
        this.heartRateStatus = heartRateStatus;
        this.bloodPressureStatus = bloodPressureStatus;
        this.respiratoryRateStatus = respiratoryRateStatus;
        this.bodyTemperatureStatus = bodyTemperatureStatus;
        this.bloodGlucoseStatus = bloodGlucoseStatus;
        this.oxygenSaturationStatus = oxygenSaturationStatus;
    }
}

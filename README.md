# EHR System

1) **Backend** - Java (Spring Boot) → EHR-Panel  
2) **Database** - Structured (MySQL) and Non-Structured (MongoDB) Data  
3) **Postman** - API Testing  
4) **Dockers** - Containerization  

This repository contains two Spring Boot projects that together form an Electronic Health Record (EHR) system. One project (**EHR_Panel**) uses MySQL for data persistence, and the other project (**EHR_Panel_Mongo**) uses MongoDB for file/document storage.


---

## Table of Contents
1. [Overview](#overview)  
2. [Project Structure](#project-structure)  
3. [Features](#features)  
4. [Technologies Used](#technologies-used)  
5. [Prerequisites](#prerequisites)  
6. [Setup & Installation](#setup--installation)  
7. [Running the Projects](#running-the-projects)  
8. [API Endpoints](#api-endpoints)  
9. [Security & Roles](#security--roles)  


---

## 1. Overview

### EHR_Panel (MySQL)
A Spring Boot application that manages:
- Patients
- Doctors
- Appointments
- Prescriptions
- Vitals

Data is stored in a MySQL database.

### EHR_Panel_Mongo (MongoDB)
A Spring Boot application that stores and retrieves PDF (or other) files associated with patients in MongoDB.

Together, these applications form a simplified EHR system where you can manage both **structured data** (patients, doctors, appointments, prescriptions, vitals) and **file uploads/downloads** for patient records.


---

## 2. Project Structure

### EHR_Panel (MySQL)


```text
EHR_Panel
├─ .idea
├─ EHR_Panel
│  ├─ src
│  │  └─ main
│  │     └─ java
│  │        ├─ com.ehr.controller
│  │        │  ├─ PatientController.java
│  │        │  └─ GlobalExceptionHandler.java
│  │        ├─ com.ehr.entity
│  │        │  ├─ Appointment.java
│  │        │  ├─ Doctor.java
│  │        │  ├─ Patient.java
│  │        │  ├─ Prescription.java
│  │        │  ├─ Security.java
│  │        │  └─ SelfVitalsRecords.java
│  │        ├─ com.ehr.repo
│  │        │  ├─ AppointmentRepository.java
│  │        │  ├─ DoctorRepository.java
│  │        │  ├─ PatientRepository.java
│  │        │  ├─ PrescriptionRepository.java
│  │        │  └─ SelfVitalsRecordsRepo.java
│  │        ├─ com.ehr.service
│  │        │  ├─ PatientService.java
│  │        │  └─ PatientServiceImpl.java
│  │        └─ com.ehr
│  │           └─ Application.java
│  ├─ src
│  │  └─ main
│  │     └─ resources
│  │        ├─ application.properties
│  │        └─ ...
└─ pom.xml
```


### EHR_Panel_Mongo (MongoDB)

```text
EHR_Panel_Mongo
├─ .idea
├─ EHR_Panel_Mongo
│  ├─ src
│  │  └─ main
│  │     └─ java
│  │        ├─ com.ehr.controller
│  │        │  └─ PatientController.java
│  │        ├─ com.ehr.entity
│  │        │  ├─ Patient.java
│  │        │  └─ Security.java
│  │        ├─ com.ehr.repo
│  │        │  └─ PatientRepository.java
│  │        ├─ com.ehr.service
│  │        │  ├─ PatientService.java
│  │        │  └─ PatientServiceImpl.java
│  │        └─ com.ehr
│  │           └─ Application.java
│  ├─ src
│  │  └─ main
│  │     └─ resources
│  │        ├─ application.properties
│  │        └─ ...
└─ pom.xml
```

---

## 3. Features

### EHR_Panel (MySQL)
- **Patient Management**: Create, read, update, and delete patient records.  
- **Doctor Management**: Create, read, update, and delete doctor records.  
- **Appointments**: Schedule and manage appointments for patients.  
- **Prescriptions**: Create and retrieve prescription details (including recommended times per day).  
- **Vitals**: Add and retrieve patient vitals with basic health checks (e.g., heart rate, blood pressure).  
- **Security**: Role-based access control (ADMIN, DOCTOR, PATIENT) using Spring Security with in-memory credentials.

### EHR_Panel_Mongo (MongoDB)
- **File Upload**: Upload PDF or other files related to a patient.  
- **File Download**: Download multiple files for a given patient as a single ZIP.  
- **File Deletion**: Delete files associated with a patient.  
- **Security**: Role-based access control (ADMIN, PATIENT) using Spring Security with in-memory credentials.

---













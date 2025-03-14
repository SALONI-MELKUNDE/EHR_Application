# EHR System

1) **Backend** - Java (Spring Boot) → EHR-Panel  
2) **Database** - Structured (MySQL) and Non-Structured (MongoDB) Data  
3) **Postman** - API Testing  

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
│  │        │  ├─ Security.java
│  │        │  └─ FileDownloadResponse.java
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


## 4. Technologies Used
- **Java 17+**
- **Spring Boot** (Web, Data JPA, Data MongoDB, Validation, Security)
- **MySQL** (for EHR_Panel)
- **MongoDB** (for EHR_Panel_Mongo)
- **Maven** (Project build tool)
- **Hibernate** (JPA provider for MySQL)
- **In-Memory Authentication** (Spring Security)
- **Tomcat** (embedded in Spring Boot)

---

## 5. Prerequisites
1. **Java 17+** installed and configured (`JAVA_HOME`).
2. **Maven 3.6+** installed (or use Maven wrapper).
3. **MySQL** server running on port `3306` (or adjust `application.properties` accordingly) for EHR_Panel.  
   - Default credentials in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3307/ehr_portal
     spring.datasource.username={{Your username}}
     spring.datasource.password={{password}}
     ```
   - Make sure you create (or let Hibernate create) a schema/database named `ehr_portal`.
4. **MongoDB** server running on port `27017` (or adjust `application.properties` accordingly) for EHR_Panel_Mongo.  
   - Default URI in `application.properties`:
     ```properties
     spring.data.mongodb.uri=mongodb://localhost:27017/ehr_portal
     ```
5. **Postman** or any REST client (optional but recommended for testing).

---


## 6. Setup & Installation
1. **Clone this repository**:
   ```bash
   https://github.com/SALONI-MELKUNDE/EHR_Application.git 
   ```

2. **Navigate to each project (EHR_Panel and EHR_Panel_Mongo) to install dependencies:**
   
    ```bash
    cd EHR_Panel
    mvn clean install
    ```

    ```bash
    cd EHR_Panel_Mongo
    mvn clean install
    ```
    
3. **Configure Database Connections:**

- **MySQL (EHR_Panel): Verify the connection details in**
  
  ```bash
  src/main/resources/application.properties
  ```

- **MongoDB (EHR_Panel_Mongo): Verify the MongoDB URI in**

  ```bash
  src/main/resources/application.properties
  ```

## 7. Running the Projects

### EHR_Panel (MySQL)

- **Using Maven:**  
  ```bash
  mvn spring-boot:run
  ```
- **Using an IDE: Run the Application.java class as a Java application.**
- **Access: The application runs on port 9094 (or as specified in the properties file).**

- **EHR_Panel_Mongo (MongoDB)**
  
- **Using Maven:**  
  ```bash
  mvn spring-boot:run
  ```
- **Using an IDE: Run the Application.java class as a Java application.**
- **Access: The application runs on port 8081 (or as specified in the properties file).**

*Note: Ensure that both MySQL and MongoDB servers are up and running before starting the applications.*


## 8. API Endpoints

### EHR_Panel (MySQL)


| **Category**     | **HTTP Method** | **Endpoint**                                      | **Description**                                                                              |
|------------------|-----------------|---------------------------------------------------|----------------------------------------------------------------------------------------------|
| **Patients**     | POST            | `/addPatients`                                    | Add a new patient with validations.                                                          |
| **Patients**     | GET             | `/getAllPatients`                                 | Retrieve all patient records.                                                                |
| **Patients**     | GET             | `/patient/{patientId}`                            | Retrieve a patient by ID.                                                                    |
| **Patients**     | PUT             | `/patientUpdate/{patientId}`                      | Update patient information.                                                                  |
| **Patients**     | DELETE          | `/patientDelete/{patientId}`                      | Delete a patient record by ID.                                                               |
| **Doctors**      | POST            | `/addDoctors`                                     | Add a new doctor with validations.                                                           |
| **Doctors**      | GET             | `/getAllDoctorRecords`                            | Retrieve all doctor records.                                                                 |
| **Doctors**      | GET             | `/doctor/{doctorId}`                              | Retrieve doctor details by ID.                                                               |
| **Doctors**      | PUT             | `/doctorUpdate/{doctorId}`                        | Update doctor information.                                                                   |
| **Doctors**      | DELETE          | `/doctorDelete/{doctorId}`                        | Delete a doctor record by ID.                                                                |
| **Appointments** | POST            | `/addAppointment`                                 | Schedule a new appointment.                                                                  |
| **Appointments** | GET             | `/allAppointment`                                 | Retrieve all appointments.                                                                   |
| **Appointments** | GET             | `/appointment/{appointmentId}`                    | Retrieve appointment details by ID.                                                          |
| **Appointments** | PUT             | `/appointmentUpdate/{appointmentId}`              | Update appointment information by ID.                                                        |
| **Appointments** | DELETE          | `/appointmentDelete/{appointmentId}`              | Delete an appointment by ID.                                                                 |
| **Prescriptions**| POST            | `/prescription`                                   | Add a new prescription record.                                                               |
| **Prescriptions**| GET             | `/getPrescription/{patientID}`                    | Retrieve prescription schedules for a patient.                                               |
| **Prescriptions**| PUT             | `/prescriptionUpdate/{patientId}`                 | Update prescription information based on patient ID.                                         |
| **Prescriptions**| DELETE          | `/prescriptionDelete/{patientId}`                 | Delete a prescription record based on patient ID.                                            |
| **Self Vitals**  | POST            | `/SelfVitalsRecords`                              | Add self vitals record with auto-evaluation of vital signs.                                  |
| **Self Vitals**  | GET             | `/getAllSelfVitalRecords`                         | Retrieve all self vitals records.                                                            |
| **Self Vitals**  | GET             | `/getSelfVitalRecordsByPatient/{patientId}`       | Retrieve self vitals records for a specific patient by ID.                                   |
| **Self Vitals**  | PUT             | `/updateSelfVitalsRecords/{patientId}`            | Update self vitals record for a patient by ID.                                               |
| **Self Vitals**  | DELETE          | `/deleteSelfVitalsRecords/{patientId}`            | Delete self vitals record for a patient by ID.                                               |



### EHR_Panel_Mongo (MongoDB)

| **HTTP Method** | **Endpoint**                     | **Description**                                                                                           | **Parameters**                                                 |
|-----------------|----------------------------------|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| POST            | `/upload`                        | Upload a file (PDF or similar) for a patient.                                                             | `file` (MultipartFile), `patient_id`, `date`                   |
| GET             | `/download/{patientId}`          | Download all files for a patient as a ZIP archive.                                                        | Path parameter: `patientId`                                    |
| DELETE          | `/deleteFile/{patientId}`        | Delete files associated with a patient.                                                                   | Path parameter: `patientId`                                    |




## 9. Security & Roles

*Both projects implement role-based access control using Spring Security with in-memory authentication.*

### EHR_Panel (MySQL) Credentials:

*ADMIN:*
- **Username: admin**
- **Password: admin123**

*DOCTOR:*
- **Username: doctor1**
- **Password: doctor123**

*PATIENT:*
- **Username: patient1**
- **Password: patient123**

*Endpoint Restrictions:*
**ADMIN has full access.**
**DOCTOR and PATIENT roles have restricted access per endpoint as defined in the security configuration.** 

### EHR_Panel_Mongo (MongoDB) Credentials:

*ADMIN:*
- **Username: admin**
- **Password: admin123**

*PATIENT:*
- **Username: patient1**
- **Password: patient123**

*Endpoint Restrictions:*
**Endpoints such as /upload, /download/**, and /deleteFile/** are accessible to users with either ADMIN or PATIENT roles.**

## 10. Testing with Postman

- **Import the API collection (if provided) into Postman.**
- **Use HTTP Basic Authentication with the credentials listed above.**
- **Test each endpoint by sending requests with the necessary parameters and payloads.**
- **Validate the response codes and payloads as per the API definitions.**

## 11. Future Enhancements

- **User Interface: Develop a frontend UI for easier interaction with the EHR system.**
- **Enhanced Security: Integrate JWT-based authentication and OAuth2 for more robust security.**
- **Scalability: Container orchestration using Kubernetes for high availability.**
- **Audit Logging: Implement detailed logging and audit trails for security and compliance.**
- **Integration: Add support for third-party healthcare systems and analytics.**

## 12. License

- **This project is licensed under the MIT License.
(Include or reference the actual LICENSE file in my repository.)**

  
## Thank you for exploring the EHR_DatabaseProject!

- **If you have any questions or suggestions, feel free to open an issue or reach out.**


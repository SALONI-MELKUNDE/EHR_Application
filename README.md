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


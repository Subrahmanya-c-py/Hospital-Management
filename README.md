# 🏥 Hospital Management System

A Console-Based Hospital Management System developed using Core Java, JDBC, and MySQL.

## 📌 Features

* Add Patient
* View Patients
* Search Patient
* Update Patient
* Delete Patient
* Add Doctor
* View Doctors
* Search Doctor
* Update Doctor
* Delete Doctor
* Book Appointment
* View Appointments
* Search Appointment
* Delete Appointment
* Admin Login System
* JDBC Database Connectivity
* MySQL Data Persistence
* Exit

## 🛠 Technologies Used

* Core Java
* JDBC
* MySQL
* OOP Concepts
* Collections Framework
* Exception Handling
* DAO Design Pattern
* Git & GitHub

## 📂 Project Structure

```text
HospitalManagementSystem/
│
├── database/
│   ├── DBConnection.java
│   └── dao/
│       ├── PatientDAO.java
│       ├── DoctorDAO.java
│       └── AppointmentDAO.java
│
├── model/
│   ├── Patient.java
│   ├── Doctor.java
│   └── Appointment.java
│
├── service/
│   └── AdminService.java
│
├── lib/
│   └── mysql-connector-j-9.6.0.jar
│
├── Main.java
├── README.md
└── .gitignore
```

## ▶ How to Run

1. Compile:

```bash
javac -cp ".;lib/*" database\DBConnection.java database\dao\PatientDAO.java database\dao\DoctorDAO.java database\dao\AppointmentDAO.java Main.java
```

2. Run:

```bash
java -cp ".;lib/*" Main
```

## 🗄 Database

* MySQL Database
* Patients Table
* Doctors Table
* Appointments Table
* Foreign Key Relationships

## Next Update or Improvement of Project

* Appointment JOIN Queries
* Java Swing GUI
* Spring Boot REST API
* Online Appointment Booking

## 👨‍💻 Author

SUBRAHMANYA

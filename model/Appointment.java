package model;

public class Appointment {

    private final int patientId;
    private final int doctorId;
    private final String date;

    public Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String toFileString() {
        return patientId + "," + doctorId + "," + date;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               " | Doctor ID: " + doctorId +
               " | Date: " + date;
    }
}
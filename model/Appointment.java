package model;

public class Appointment {
    private int patientId;
    private int doctorId;
    private String date;

    public Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }

    public String toString() {
        return "Patient ID: " + patientId +
               " | Doctor ID: " + doctorId +
               " | Date: " + date;
    }
}

package service;

import model.Appointment;
import java.util.ArrayList;
import java.io.*;

public class AppointmentService {

    private ArrayList<Appointment> appointments = new ArrayList<>();
    private final String FILE_NAME = "appointments.txt";

    public AppointmentService() {
        loadFromFile();
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
        saveToFile(appointment);
        System.out.println("Appointment booked successfully!");
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment a : appointments) {
                System.out.println(a);
            }
        }
    }

    private void saveToFile(Appointment appointment) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(appointment.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving appointment data.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Loaded: " + line);
            }
        } catch (IOException e) {
            System.out.println("No previous appointment data found.");
        }
    }
}

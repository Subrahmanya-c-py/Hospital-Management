package service;

import java.io.*;
import java.util.*;
import model.Appointment;

public class AppointmentService {

    private final List<Appointment> appointments = new ArrayList<>();
    private static final String FILE_NAME = "appointments.txt";

    public AppointmentService() {
        loadFromFile();
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
        saveToFile();
        System.out.println("Appointment booked successfully!");
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        appointments.forEach(System.out::println);
    }

    public void deleteAppointment(int patientId, int doctorId) {
        boolean removed = appointments.removeIf(a ->
                a.getPatientId() == patientId &&
                a.getDoctorId() == doctorId
        );

        if (removed) {
            saveToFile();
            System.out.println("Appointment deleted successfully!");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving appointment data.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                Appointment appointment = new Appointment(
                        Integer.parseInt(data[0]),
                        Integer.parseInt(data[1]),
                        data[2]
                );

                appointments.add(appointment);
            }

        } catch (IOException e) {
            System.out.println("Error loading appointment data." + e);
        }
    }
}
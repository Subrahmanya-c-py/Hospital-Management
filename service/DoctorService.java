package service;

import java.io.*;
import java.util.*;
import model.Doctor;

public class DoctorService {

    private final Map<Integer, Doctor> doctors = new HashMap<>();
    private static final String FILE_NAME = "doctors.txt";

    public DoctorService() {
        loadFromFile();
    }

    public void addDoctor(Doctor doctor) {
        if (doctors.containsKey(doctor.getId())) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        doctors.put(doctor.getId(), doctor);
        saveToFile();
        System.out.println("Doctor added successfully!");
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        doctors.values().forEach(System.out::println);
    }

    public Doctor searchDoctor(int id) {
        return doctors.get(id);
    }

    public void deleteDoctor(int id) {
        if (doctors.remove(id) != null) {
            saveToFile();
            System.out.println("Doctor deleted successfully!");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void updateDoctor(int id, String name, String specialization) {
        Doctor doctor = doctors.get(id);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        doctor.setName(name);
        doctor.setSpecialization(specialization);

        saveToFile();
        System.out.println("Doctor updated successfully!");
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Doctor doctor : doctors.values()) {
                writer.write(doctor.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving doctor data." + e);
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                Doctor doctor = new Doctor(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]
                );

                doctors.put(doctor.getId(), doctor);
            }

        } catch (IOException e) {
            System.out.println("Error loading doctor data." + e);
        }
    }
}
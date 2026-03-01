package service;

import java.io.*;
import java.util.*;
import model.Patient;

public class PatientService {

    private final Map<Integer, Patient> patients = new HashMap<>();
    private static final String FILE_NAME = "patients.txt";

    public PatientService() {
        loadFromFile();
    }

    public void addPatient(Patient patient) {
        if (patients.containsKey(patient.getId())) {
            System.out.println("Patient ID already exists!");
            return;
        }

        patients.put(patient.getId(), patient);
        saveToFile();
        System.out.println("Patient added successfully!");
    }

    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        patients.values().forEach(System.out::println);
    }

    public Patient searchPatient(int id) {
        return patients.get(id);
    }

    public void deletePatient(int id) {
        if (patients.remove(id) != null) {
            saveToFile();
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    public void updatePatient(int id, String name, int age, String disease) {
        Patient patient = patients.get(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.setName(name);
        patient.setAge(age);
        patient.setDisease(disease);

        saveToFile();
        System.out.println("Patient updated successfully!");
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Patient patient : patients.values()) {
                writer.write(patient.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving patient data.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                Patient patient = new Patient(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]
                );

                patients.put(patient.getId(), patient);
            }

        } catch (IOException e) {
            System.out.println("Error loading patient data.");
        }
    }
}
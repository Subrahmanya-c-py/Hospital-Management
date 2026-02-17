package service;

import model.Patient;
import java.util.*;
import java.io.*;

public class PatientService {

    private ArrayList<Patient> patients = new ArrayList<>();
    private final String FILE_NAME = "patients.txt";

    public PatientService() {
        loadFromFile();
    }

    public void addPatient(Patient patient) {

    if (searchPatient(patient.getId()) != null) {
        System.out.println("Patient ID already exists! Cannot add duplicate.");
        return;
    }

    patients.add(patient);
    rewriteFile();
    System.out.println("Patient added successfully!");
}


    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    public Patient searchPatient(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void deletePatient(int id) {
        Patient p = searchPatient(id);
        if (p != null) {
            patients.remove(p);
            rewriteFile();
            System.out.println("Patient deleted successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    public void updatePatient(int id, String name, int age, String disease) {
        Patient p = searchPatient(id);
        if (p != null) {
            p.setName(name);
            p.setAge(age);
            p.setDisease(disease);
            rewriteFile();
            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Patient not found.");
        }
    }

    private void rewriteFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Patient p : patients) {
                bw.write(p.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Patient p = new Patient(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3]
                );
                patients.add(p);
            }
        } catch (IOException e) {
            System.out.println("No previous patient data found.");
        }
    }
}

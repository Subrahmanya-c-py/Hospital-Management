package service;

import java.io.*;
import java.util.*;
import model.Doctor;

public class DoctorService {

    private ArrayList<Doctor> doctors = new ArrayList<>();
    private final String FILE_NAME = "doctors.txt";

    public DoctorService() {
        loadFromFile();
    }

    public void addDoctor(Doctor doctor) {

        if (searchDoctor(doctor.getId()) != null) {
            System.out.println("Doctor ID already exists!");
            return;
        }

        doctors.add(doctor);
        rewriteFile();
        System.out.println("Doctor added successfully!");
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }
    }

    public Doctor searchDoctor(int id) {
        for (Doctor d : doctors) {
            if (d.getId() == id)
                return d;
        }
        return null;
    }

    private void rewriteFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Doctor d : doctors) {
                bw.write(d.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing doctor file.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Doctor d = new Doctor(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]
                );
                doctors.add(d);
            }
        } catch (IOException e) {
            System.out.println("No previous doctor data found.");
        }
    }
}

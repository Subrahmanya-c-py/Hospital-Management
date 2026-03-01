package model;

import java.util.Objects;

public class Doctor {

    private final int id; // ID should never change
    private String name;
    private String specialization;

    public Doctor(int id, String name, String specialization) {
        if (id <= 0) {
            throw new IllegalArgumentException("Doctor ID must be positive.");
        }
        this.id = id;
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.specialization = Objects.requireNonNull(specialization, "Specialization cannot be null");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public void setSpecialization(String specialization) {
        this.specialization = Objects.requireNonNull(specialization, "Specialization cannot be null");
    }

    public String toFileString() {
        return id + "," + name + "," + specialization;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + name +
               " | Specialization: " + specialization;
    }
}
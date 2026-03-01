package model;

import java.util.Objects;

public class Patient {

    private final int id; // ID should not change
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        if (id <= 0) {
            throw new IllegalArgumentException("Patient ID must be positive.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }

        this.id = id;
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.disease = Objects.requireNonNull(disease, "Disease cannot be null");
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        this.age = age;
    }

    public void setDisease(String disease) {
        this.disease = Objects.requireNonNull(disease, "Disease cannot be null");
    }

    public String toFileString() {
        return id + "," + name + "," + age + "," + disease;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + name +
               " | Age: " + age +
               " | Disease: " + disease;
    }
}
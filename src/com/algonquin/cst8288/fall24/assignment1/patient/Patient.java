package com.algonquin.cst8288.fall24.assignment1.patient;

import com.algonquin.cst8288.fall24.assignment1.prescription.Prescription;

/**
 * Patient class that holds all patient data.
 */
public abstract class Patient {

    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String dateOfBirth;
    private long age;
    private String lifeStage;
    private String plannedTreatment;
    private Prescription prescription;  // Added Prescription object

    public Patient(String id, String name, String email, String phoneNumber, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and setters for Patient details
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getAge() {
        return age;
    }

    public String getLifeStage() {
    	
        return lifeStage;
    }

    public String getPlannedTreatment() {
        return plannedTreatment;
    }

    public Prescription getPrescription() {
        return prescription;  // Getter for Prescription
    }

    // Setters for Patient details
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public void setLifeStage(String lifeStage) {
        this.lifeStage = lifeStage;
    }

    public void setPlannedTreatment(String plannedTreatment) {
        this.plannedTreatment = plannedTreatment;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;  // Setter for Prescription
    }

    // Abstract method admit to be implemented by subclasses
    public abstract void admit();
}






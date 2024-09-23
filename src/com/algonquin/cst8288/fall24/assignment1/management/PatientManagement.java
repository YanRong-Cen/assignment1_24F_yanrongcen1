package com.algonquin.cst8288.fall24.assignment1.management;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.prescription.PrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.treatment.TreatmentPlan;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PatientManagement {

    private final PatientValidator patientValidator = new PatientValidator();
    private final PatientAgeService patientAgeService = new PatientAgeService();

    public boolean validatePatientData(Patient patient) {
        return patientValidator.validate(patient);
    }

    public void createTreatmentPlan(Patient patient, TreatmentPlan treatmentPlan) {
        patient.setAge(patientAgeService.calculatePatientAge(patient.getDateOfBirth()));
        patient.setLifeStage(patientAgeService.determineLifeStage(patient.getAge()));
     // Call the treatment plan's createTreatmentPlan() method and set it to the patient
        String plan = treatmentPlan.createTreatmentPlan(patient);
        patient.setPlannedTreatment(plan);
        if (patient.getLifeStage() == null) {
            throw new IllegalArgumentException("Life stage is not set for the patient.");
        }
        
    }

    public void generatePrescription(Patient patient, String filename, PrescriptionService prescriptionService) throws IOException {
        BufferedWriter bwriter = new BufferedWriter(new FileWriter(filename));
        bwriter.write(prescriptionService.generatePrescription(patient));  // Dependency on abstraction (PrescriptionService)
        bwriter.close();
    }
}

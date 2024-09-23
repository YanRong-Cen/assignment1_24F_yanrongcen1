package com.alognquin.cst8288.fall24.assignment1;

import com.algonquin.cst8288.fall24.assignment1.management.PatientManagement;
import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import com.algonquin.cst8288.fall24.assignment1.patient.Outpatient;
import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.prescription.OnlinePrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.prescription.PrintablePrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.prescription.Prescription;
import com.algonquin.cst8288.fall24.assignment1.treatment.MedicationTreatmentPlan;
import com.algonquin.cst8288.fall24.assignment1.treatment.SurgeryTreatmentPlan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;

/*public class Physician {

    public static void main(String[] args) throws IOException {
        // Instantiate PatientManagement
        PatientManagement patientManagement = new PatientManagement();

        // Create two patients (one inpatient and one outpatient)
        Patient inpatient = new Inpatient("001", "John Doe", "john@example.com", "1234567890", "1985-05-10", "A123");
        Patient outpatient = new Outpatient("002", "Jane Smith", "jane@example.com", "0987654321", "2005-07-15", "2024-10-10");

        // Set treatment plans for patients
        patientManagement.createTreatmentPlan(inpatient, new SurgeryTreatmentPlan());
        patientManagement.createTreatmentPlan(outpatient, new MedicationTreatmentPlan());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date followUpDate = null;
        try {
            followUpDate = dateFormat.parse("2024-07-11");  // Parse string to Date
        } catch (ParseException e) {
            System.out.println("Date parsing error: " + e.getMessage());
            e.printStackTrace();
        }

        // Create prescription details and assign to the patient objects
        Prescription inpatientPrescription = new Prescription(3, 180, "Chronic Disease", null, "Low", true, followUpDate);
        inpatient.setPrescription(inpatientPrescription);

        Prescription outpatientPrescription = new Prescription(2, 14, "Infection", null, null, false, null);
        outpatient.setPrescription(outpatientPrescription);

        // Generate and save prescriptions in both online and printable formats
        patientManagement.generatePrescription(inpatient, "john_doe_prescription.html", new OnlinePrescriptionService());
        patientManagement.generatePrescription(outpatient, "jane_smith_prescription.txt", new PrintablePrescriptionService());
    }
}*/

public class Physician {

    public static void main(String[] args) throws IOException, ParseException {
        // Instantiate PatientManagement
        PatientManagement patientManagement = new PatientManagement();

        // Create two patients (one inpatient and one outpatient)
        Patient inpatient = new Inpatient("001", "John Doe", "john@example.com", "1234567890", "1985-05-10", "A123");
        Patient outpatient = new Outpatient("002", "Jane Smith", "jane@example.com", "0987654321", "2005-07-15", "2024-10-10");
        
        inpatient.setLifeStage(Constants.ADULT); // Set to the appropriate constant
        outpatient.setLifeStage(Constants.CHILD);

        // Set treatment plans for patients
        System.out.println("=== Treatment Plans ===");
        patientManagement.createTreatmentPlan(inpatient, new SurgeryTreatmentPlan());
        System.out.println("Inpatient Treatment Plan: " + inpatient.getPlannedTreatment());
        
        patientManagement.createTreatmentPlan(outpatient, new MedicationTreatmentPlan());
        System.out.println("Outpatient Treatment Plan: " + outpatient.getPlannedTreatment());

        // Create date objects for the prescriptions
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date followUpDate = dateFormat.parse("2024-07-11");  // Parse string to Date

        // Create prescription details and assign to the patient objects
        Prescription inpatientPrescription = new Prescription(3, 180, "Chronic Disease", null, "Low", true, followUpDate);
        inpatient.setPrescription(inpatientPrescription);

        Prescription outpatientPrescription = new Prescription(2, 14, "Infection", null, null, false, null);
        outpatient.setPrescription(outpatientPrescription);

        // Print the prescription details to the console
        System.out.println("\n=== Prescriptions ===");
        System.out.println("Inpatient Prescription: ");
        System.out.println(inpatient.getPrescription().getPrescriptionDetails());

        System.out.println("\nOutpatient Prescription: ");
        System.out.println(outpatient.getPrescription().getPrescriptionDetails());

        // Generate and save prescriptions in both online and printable formats
        System.out.println("\n=== Saving Prescriptions to Files ===");
        patientManagement.generatePrescription(inpatient, "john_doe_prescription.html", new OnlinePrescriptionService());
        patientManagement.generatePrescription(outpatient, "jane_smith_prescription.txt", new PrintablePrescriptionService());
        System.out.println("Prescriptions saved to john_doe_prescription.html and jane_smith_prescription.txt.");
    }
}






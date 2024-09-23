//package com.algonquin.cst8288.fall24.assignment1.prescription;

//import com.algonquin.cst8288.fall24.assignment1.patient.Patient;


/**
 * 
 * Implement this
 * 
 */
package com.algonquin.cst8288.fall24.assignment1.prescription;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

public class PrintablePrescriptionService implements PrescriptionService {

    @Override
    public String generatePrescription(Patient patient) {
        Prescription prescription = patient.getPrescription();  // Assuming patient has a Prescription object

        StringBuilder prescriptionTxt = new StringBuilder();
        prescriptionTxt.append("Patient Name: ").append(patient.getName()).append("\n");
        prescriptionTxt.append("Date of Birth: ").append(patient.getDateOfBirth()).append("\n");
        prescriptionTxt.append("Prescription Details: \n");
        prescriptionTxt.append(prescription.getPrescriptionDetails());  // Utilize the method from Prescription.java
        
        return prescriptionTxt.toString();  // This can be written to a .txt file later
    }
}


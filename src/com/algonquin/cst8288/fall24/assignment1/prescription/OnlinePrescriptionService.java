package com.algonquin.cst8288.fall24.assignment1.prescription;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

/**
 * 
 * Implement this
 * 
 */
public class OnlinePrescriptionService implements PrescriptionService{

	@Override
	public String generatePrescription(Patient patient) {
	    Prescription prescription = patient.getPrescription();
	    StringBuilder html = new StringBuilder();
	    
	    html.append("<html><body>");
	    html.append("Patient Name: " + patient.getName() + "<br>");
	    html.append("Date of Birth: " + patient.getDateOfBirth() + "<br>");
	    html.append("Prescription Details: <br>");
	    html.append(prescription.getPrescriptionDetails().replace("\n", "<br>"));
	    html.append("</body></html>");
	    
	    return html.toString();
	}
	
}

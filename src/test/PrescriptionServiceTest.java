package test;
//package com.alognquin.cst8288.fall24.assignment1;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;



import com.algonquin.cst8288.fall24.assignment1.management.PatientManagement;
import com.algonquin.cst8288.fall24.assignment1.patient.Inpatient;
import com.algonquin.cst8288.fall24.assignment1.patient.Outpatient;
import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.algonquin.cst8288.fall24.assignment1.prescription.OnlinePrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.prescription.PrintablePrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.prescription.Prescription;
import com.algonquin.cst8288.fall24.assignment1.prescription.PrescriptionService;
import com.algonquin.cst8288.fall24.assignment1.treatment.MedicationTreatmentPlan;
import com.algonquin.cst8288.fall24.assignment1.treatment.SurgeryTreatmentPlan;
import com.algonquin.cst8288.fall24.assignment1.treatment.TreatmentPlan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;



class PrescriptionServiceTest {

	   @Test
	    public void testOnlinePrescriptionService() {
	        Patient patient = new Inpatient("005", "John Online", "john.online@example.com", "1234567890", "1980-01-01", "A123");

	        // Create a prescription
	        Prescription prescription = new Prescription(3, 180, "Chronic Disease", null, "Low", true, null);
	        patient.setPrescription(prescription);

	        // Generate online prescription
	        PrescriptionService onlineService = new OnlinePrescriptionService();
	        String prescriptionHtml = onlineService.generatePrescription(patient);

	        assertTrue(prescriptionHtml.contains("<html>"));
	        assertTrue(prescriptionHtml.contains("Patient Name: John Online"));
	        assertTrue(prescriptionHtml.contains("Chronic Disease"));
	    }

	    @Test
	    public void testPrintablePrescriptionService() {
	        Patient patient = new Outpatient("006", "Jane Printable", "jane.printable@example.com", "0987654321", "2000-01-01", "2024-10-10");

	        // Create a prescription
	        Prescription prescription = new Prescription(2, 14, "Infection", null, null, false, null);
	        patient.setPrescription(prescription);

	        // Generate printable prescription
	        PrescriptionService printableService = new PrintablePrescriptionService();
	        String prescriptionTxt = printableService.generatePrescription(patient);

	        assertTrue(prescriptionTxt.contains("Patient Name: Jane Printable"));
	        assertTrue(prescriptionTxt.contains("Infection"));
	    }

}

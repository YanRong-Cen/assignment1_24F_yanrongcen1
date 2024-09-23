/**
 * 
 */
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
import com.algonquin.cst8288.fall24.assignment1.treatment.MedicationTreatmentPlan;
import com.algonquin.cst8288.fall24.assignment1.treatment.SurgeryTreatmentPlan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */
class PatientManagementTest {

	private PatientManagement patientManagement;
    private Patient inpatient;
    private Patient outpatient;

    @BeforeEach
    void setUp() {
        patientManagement = new PatientManagement();
        inpatient = new Inpatient("001", "John Doe", "john@example.com", "1234567890", "1985-05-10", "A123");
        outpatient = new Outpatient("002", "Jane Smith", "jane@example.com", "0987654321", "2005-07-15", "2024-10-10");
    }

    @AfterEach
    void tearDown() {
        // Cleanup if needed
    }

    @Test
    void testCreateTreatmentPlanForInpatient() {
        patientManagement.createTreatmentPlan(inpatient, new SurgeryTreatmentPlan());
        assertNotNull(inpatient.getPlannedTreatment());
        assertTrue(inpatient.getPlannedTreatment().contains("requires surgery"));
    }

    @Test
    void testCreateTreatmentPlanForOutpatient() {
        patientManagement.createTreatmentPlan(outpatient, new MedicationTreatmentPlan());
        assertNotNull(outpatient.getPlannedTreatment());
        assertTrue(outpatient.getPlannedTreatment().contains("requires medication treatment"));
    }

    @Test
    void testGeneratePrescriptionForInpatient() throws IOException {
        Prescription inpatientPrescription = new Prescription(3, 180, "Chronic Disease", null, "Low", true, null);
        inpatient.setPrescription(inpatientPrescription);

        String filename = "john_doe_prescription_test.html";
        patientManagement.generatePrescription(inpatient, filename, new OnlinePrescriptionService());

        File file = new File(filename);
        assertTrue(file.exists());
        file.delete(); // Cleanup
    }

    @Test
    void testGeneratePrescriptionForOutpatient() throws IOException {
        Prescription outpatientPrescription = new Prescription(2, 14, "Infection", null, null, false, null);
        outpatient.setPrescription(outpatientPrescription);

        String filename = "jane_smith_prescription_test.txt";
        patientManagement.generatePrescription(outpatient, filename, new PrintablePrescriptionService());

        File file = new File(filename);
        assertTrue(file.exists());
        file.delete(); // Cleanup
    }

}

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
import com.algonquin.cst8288.fall24.assignment1.treatment.TreatmentPlan;
import com.alognquin.cst8288.fall24.assignment1.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class TreatmentPlantTest {

	 @Test
	    void testMedicationTreatmentPlanForChild() {
		 Outpatient child = new Outpatient("003", "Sam Child", "sam@example.com", "1234567890", "2020-01-01", "2024-10-10");
		    child.setAge(4); // Set as a child
		    child.setLifeStage(Constants.CHILD); // Set life stage
		    child.setPlannedTreatment(Constants.ACUTE); // Set a known planned treatment

		    TreatmentPlan treatmentPlan = new MedicationTreatmentPlan();
		    String plan = treatmentPlan.createTreatmentPlan(child);
		    
		    // Debug print
		    System.out.println("Generated Treatment Plan: " + plan);

		    assertTrue(plan.contains("Children: 1 time per day."));
		    assertTrue(plan.contains("Duration: 7 days (No medication)."));
	    }

	    @Test
	    void testSurgeryTreatmentPlanForAdult() {
	        Patient adult = new Inpatient("004", "Anna Adult", "anna@example.com", "0987654321", "1990-01-01", "A123");
	        adult.setAge(30); // Set as an adult

	        TreatmentPlan treatmentPlan = new SurgeryTreatmentPlan();
	        String plan = treatmentPlan.createTreatmentPlan(adult);

	        assertTrue(plan.contains("requires surgery"));
	        assertTrue(plan.contains("Age Risk: Low"));
	        assertTrue(plan.contains("Fasting 8 hours before"));
	    }
}

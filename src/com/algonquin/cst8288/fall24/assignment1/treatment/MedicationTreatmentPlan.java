package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;
import com.alognquin.cst8288.fall24.assignment1.Constants;

public class MedicationTreatmentPlan implements TreatmentPlan {

    @Override
    public String createTreatmentPlan(Patient patient) {
        StringBuilder treatment = new StringBuilder();
        treatment.append("Patient requires medication treatment.\n");

        if (patient.getLifeStage().equals(Constants.CHILD)) {
            treatment.append("Children: 1 time per day.\n");
        } else if (patient.getLifeStage().equals(Constants.YOUTH)) {
            treatment.append("Youth: 2 times per day.\n");
        } else {
            treatment.append("Adult: 3 times per day.\n");
        }

        String plannedTreatment = patient.getPlannedTreatment();
        if (plannedTreatment == null) {
            treatment.append("No planned treatment specified.\n");
        } else {
            switch (plannedTreatment) {
                case Constants.ACUTE:
                    treatment.append("Duration: 7 days (No medication).\n");
                    break;
                case Constants.INFECTION:
                    treatment.append("Duration: 14 days (Antibiotics).\n");
                    break;
                case Constants.CHRONIC:
                    treatment.append("Duration: 180 days (Specialized Medication).\n");
                    break;
                default:
                    treatment.append("Unknown treatment type.\n");
                    break;
            }
        }
        patient.setPlannedTreatment(treatment.toString());

        return treatment.toString();
    
    }
    
}


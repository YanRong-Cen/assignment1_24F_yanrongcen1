//package com.algonquin.cst8288.fall24.assignment1.treatment;

//import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

/**
 * 
 * This class is responsible for implementing the business logic related to generating a treatment plan. 
 * 
 * You can use any method you prefer, such as StringBuilder or standard String, to construct the plan. Think of
 * treatment plan is a doctor notes in a summary format. 
 * Later, you will attach the treatment plan to detailed prescription.
 * 
 * An example might look like this:
 * "The patient is diagnosed with xxx and requires surgery.
 *  The patient is xxx years old with a risk factor of xxx. It is required to perform a minor surgery
 *  in order to address the xxx issue."
 * 
 * */


package com.algonquin.cst8288.fall24.assignment1.treatment;

import com.algonquin.cst8288.fall24.assignment1.patient.Patient;

public class SurgeryTreatmentPlan implements TreatmentPlan {

    @Override
    public String createTreatmentPlan(Patient patient) {
        StringBuilder treatment = new StringBuilder();
        treatment.append("The patient requires surgery.\n");

        if (patient.getAge() < 6) {
            treatment.append("Age Risk: High, No fasting, Follow-up next day.\n");
        } else if (patient.getAge() <= 18) {
            treatment.append("Age Risk: Medium, Fasting 2 hours before, Follow-up in a week.\n");
        } else {
            treatment.append("Age Risk: Low, Fasting 8 hours before, Follow-up in a month.\n");
        }
        patient.setPlannedTreatment(treatment.toString());
        return treatment.toString();
    }
}


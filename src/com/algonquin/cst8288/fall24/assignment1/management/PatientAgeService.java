package com.algonquin.cst8288.fall24.assignment1.management;

import com.alognquin.cst8288.fall24.assignment1.Constants;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PatientAgeService {

    public long calculatePatientAge(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(dob, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

    public String determineLifeStage(long age) {
        return (age <= 6) ? Constants.CHILD : (age <= 18) ? Constants.YOUTH : Constants.ADULT;
    }
}

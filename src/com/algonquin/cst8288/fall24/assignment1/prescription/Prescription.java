//package com.algonquin.cst8288.fall24.assignment1.prescription;

//import java.util.Date;

/**
 * 
 * Calculate the details of the prescription according to the business rules.
 * The information to include should cover daily doses, duration, disease type,
 * surgery date, etc.
 * 
 */


package com.algonquin.cst8288.fall24.assignment1.prescription;

import java.util.Date;

public class Prescription {
    
    private long dailyDosageCount;
    private long duration;
    private String diseaseType;
    private Date surgeryDate;
    private String riskFactor;
    private boolean isFastingRequired;
    private Date followUpDate;
    
    // Constructor to initialize prescription data
    public Prescription(long dailyDosageCount, long duration, String diseaseType, 
                        Date surgeryDate, String riskFactor, boolean isFastingRequired, Date followUpDate ) {
        this.dailyDosageCount = dailyDosageCount;
        this.duration = duration;
        this.diseaseType = diseaseType;
        this.surgeryDate = surgeryDate;
        this.riskFactor = riskFactor;
        this.isFastingRequired = isFastingRequired;
        //dont forget to erase and put default
        this.followUpDate = followUpDate;
    }

    // Getters and Setters
    public long getDailyDosageCount() {
        return dailyDosageCount;
    }

    public void setDailyDosageCount(long dailyDosageCount) {
        this.dailyDosageCount = dailyDosageCount;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Date getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(Date surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public String getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(String riskFactor) {
        this.riskFactor = riskFactor;
    }

    public boolean isFastingRequired() {
        return isFastingRequired;
    }

    public void setFastingRequired(boolean isFastingRequired) {
        this.isFastingRequired = isFastingRequired;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    // Additional methods to construct prescription details
    public String getPrescriptionDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Disease Type: " + diseaseType + "\n");
        details.append("Daily Dosage: " + dailyDosageCount + " times per day\n");
        details.append("Duration: " + duration + " days\n");

        if (surgeryDate != null) {
            details.append("Surgery Date: " + surgeryDate.toString() + "\n");
        } else {
            details.append("Surgery Date: Not applicable\n");
        }

        if (riskFactor != null) {
            details.append("Risk Factor: " + riskFactor + "\n");
        } else {
            details.append("Risk Factor: Not specified\n");
        }

        details.append("Fasting Required: " + (isFastingRequired ? "Yes" : "No") + "\n");

        if (followUpDate != null) {
            details.append("Follow-Up Date: " + followUpDate.toString() + "\n");
        } else {
            details.append("Follow-Up Date: Not applicable\n");
        }

        return details.toString();
    }
}

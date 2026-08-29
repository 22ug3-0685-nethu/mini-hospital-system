package models;

public class TreatmentRecord {
    private int patientId;
    private String treatmentDetails;
    private String timestamp;
    
    // Pointer for Stack
    public TreatmentRecord next;

    public TreatmentRecord(int patientId, String treatmentDetails, String timestamp) {
        this.patientId = patientId;
        this.treatmentDetails = treatmentDetails;
        this.timestamp = timestamp;
        this.next = null;
    }

    public int getPatientId() { return patientId; }
    public String getTreatmentDetails() { return treatmentDetails; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Treatment [Patient ID=" + patientId + ", Details=" + treatmentDetails + ", Time=" + timestamp + "]";
    }
}

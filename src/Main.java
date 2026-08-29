import java.util.Scanner;
import datastructures.PatientBST;
import datastructures.EmergencyQueue;
import datastructures.TreatmentStack;
import models.Patient;
import models.TreatmentRecord;
import models.Visit;

public class Main {
    private static PatientBST patientRecords = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static TreatmentStack treatmentHistory = new TreatmentStack();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Mini Hospital Emergency Management System ---");
            System.out.println("1. Register a New Patient (BST)");
            System.out.println("2. Search for a Patient (BST)");
            System.out.println("3. Delete a Patient (BST)");
            System.out.println("4. Display All Patients (BST In-Order)");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Treat Next Patient in Emergency Queue");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. View Recent Treatment History (Stack)");
            System.out.println("9. Add Visit History to a Patient");
            System.out.println("10. View Patient Visit History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    searchPatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    patientRecords.inOrderTraversal();
                    break;
                case 5:
                    enqueuePatient();
                    break;
                case 6:
                    treatPatient();
                    break;
                case 7:
                    emergencyQueue.displayQueue();
                    break;
                case 8:
                    treatmentHistory.displayStack();
                    break;
                case 9:
                    addVisitToPatient();
                    break;
                case 10:
                    viewPatientVisits();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void registerPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (patientRecords.search(id) != null) {
            System.out.println("Patient with this ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient newPatient = new Patient(id, name, age, contact, condition);
        patientRecords.insert(newPatient);
    }

    private static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();
        Patient p = patientRecords.search(id);
        if (p != null) {
            System.out.println("Patient Found: " + p);
        } else {
            System.out.println("Patient ID not found.");
        }
    }

    private static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        patientRecords.delete(id);
    }

    private static void enqueuePatient() {
        System.out.print("Enter Patient ID to add to emergency queue: ");
        int id = scanner.nextInt();
        Patient p = patientRecords.search(id);
        if (p != null) {
            emergencyQueue.enqueue(p);
        } else {
            System.out.println("Patient not found. Please register the patient first.");
        }
    }

    private static void treatPatient() {
        Patient p = emergencyQueue.dequeue();
        if (p != null) {
            System.out.print("Enter treatment details for " + p.getName() + ": ");
            String details = scanner.nextLine();
            String timestamp = java.time.LocalDateTime.now().toString();
            
            TreatmentRecord record = new TreatmentRecord(p.getPatientId(), details, timestamp);
            treatmentHistory.push(record);
            System.out.println("Treatment completed and saved to history.");
        }
    }

    private static void addVisitToPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        Patient p = patientRecords.search(id);
        
        if (p != null) {
            System.out.print("Enter Visit ID: ");
            int vId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Visit Date: ");
            String date = scanner.nextLine();
            System.out.print("Enter Doctor Name: ");
            String doctor = scanner.nextLine();
            System.out.print("Enter Diagnosis: ");
            String diagnosis = scanner.nextLine();
            System.out.print("Enter Treatment: ");
            String treatment = scanner.nextLine();
            
            Visit newVisit = new Visit(vId, date, doctor, diagnosis, treatment);
            p.getVisitHistory().addVisit(newVisit);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void viewPatientVisits() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        Patient p = patientRecords.search(id);
        
        if (p != null) {
            System.out.println("Visit History for " + p.getName() + ":");
            p.getVisitHistory().displayHistory();
        } else {
            System.out.println("Patient not found.");
        }
    }
}

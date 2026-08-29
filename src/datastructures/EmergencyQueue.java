package datastructures;

import models.Patient;

public class EmergencyQueue {
    class Node {
        Patient patient;
        Node next;

        public Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front, rear;

    public EmergencyQueue() {
        this.front = this.rear = null;
    }

    // Enqueue - add a patient to the waiting queue
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (this.rear == null) {
            this.front = this.rear = newNode;
            System.out.println("Patient " + patient.getName() + " added to the emergency queue.");
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
        System.out.println("Patient " + patient.getName() + " added to the emergency queue.");
    }

    // Dequeue - remove the next patient for treatment
    public Patient dequeue() {
        if (this.front == null) {
            System.out.println("The emergency queue is empty. No patients to treat.");
            return null;
        }
        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }
        
        System.out.println("Patient " + temp.patient.getName() + " is now being treated.");
        return temp.patient;
    }

    // Display all patients currently waiting
    public void displayQueue() {
        if (this.front == null) {
            System.out.println("The emergency queue is empty.");
            return;
        }
        System.out.println("Patients currently waiting in emergency queue:");
        Node temp = this.front;
        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }

    // Appropriate handling of an empty queue
    public boolean isEmpty() {
        return this.front == null;
    }
}

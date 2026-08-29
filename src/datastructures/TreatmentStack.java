package datastructures;

import models.TreatmentRecord;

public class TreatmentStack {
    private TreatmentRecord top;

    public TreatmentStack() {
        this.top = null;
    }

    // Push - add a completed treatment record
    public void push(TreatmentRecord record) {
        if (top == null) {
            top = record;
        } else {
            record.next = top;
            top = record;
        }
        System.out.println("Treatment record added to the stack.");
    }

    // Pop - remove the most recently completed treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("The treatment stack is empty. No records to remove.");
            return null;
        }
        TreatmentRecord temp = top;
        top = top.next;
        temp.next = null; // isolate the popped record
        System.out.println("Most recent treatment record removed.");
        return temp;
    }

    // Display treatment records
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("The treatment stack is empty.");
            return;
        }
        System.out.println("Treatment History (Most recent first):");
        TreatmentRecord temp = top;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // Appropriate handling of an empty stack
    public boolean isEmpty() {
        return top == null;
    }
}

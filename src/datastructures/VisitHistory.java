package datastructures;

import models.Visit;

public class VisitHistory {
    private Visit head;

    public VisitHistory() {
        this.head = null;
    }

    public void addVisit(Visit visit) {
        if (head == null) {
            head = visit;
        } else {
            Visit temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = visit;
        }
        System.out.println("Visit added successfully.");
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        Visit current = head;
        Visit previous = null;

        while (current != null && current.getVisitId() != visitId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Visit ID not found.");
            return;
        }

        previous.next = current.next;
        System.out.println("Visit removed successfully.");
    }

    public Visit searchVisit(int visitId) {
        Visit temp = head;
        while (temp != null) {
            if (temp.getVisitId() == visitId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        Visit temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

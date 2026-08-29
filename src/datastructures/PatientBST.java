package datastructures;

import models.Patient;

public class PatientBST {

    class Node {
        Patient patient;
        Node left, right;

        public Node(Patient item) {
            patient = item;
            left = right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    // Insert a new patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
        System.out.println("Patient " + patient.getName() + " inserted successfully.");
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return root;
        }
        if (patient.getPatientId() < root.patient.getPatientId())
            root.left = insertRec(root.left, patient);
        else if (patient.getPatientId() > root.patient.getPatientId())
            root.right = insertRec(root.right, patient);
        return root;
    }

    // Search for a patient using Patient ID
    public Patient search(int id) {
        Node result = searchRec(root, id);
        if (result != null) {
            return result.patient;
        }
        return null;
    }

    private Node searchRec(Node root, int id) {
        if (root == null || root.patient.getPatientId() == id)
            return root;
        if (root.patient.getPatientId() > id)
            return searchRec(root.left, id);
        return searchRec(root.right, id);
    }

    // Delete a patient
    public void delete(int id) {
        if (search(id) == null) {
            System.out.println("Patient ID " + id + " not found. Deletion failed.");
            return;
        }
        root = deleteRec(root, id);
        System.out.println("Patient ID " + id + " deleted successfully.");
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) return root;

        if (id < root.patient.getPatientId())
            root.left = deleteRec(root.left, id);
        else if (id > root.patient.getPatientId())
            root.right = deleteRec(root.right, id);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest in the right subtree)
            root.patient = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient minValue(Node root) {
        Patient minv = root.patient;
        while (root.left != null) {
            minv = root.left.patient;
            root = root.left;
        }
        return minv;
    }

    // Perform an in-order traversal
    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("No patient records found.");
            return;
        }
        System.out.println("Patient Records (Ascending Order of ID):");
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }
}

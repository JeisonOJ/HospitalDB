package controller;

import entity.Patient;
import model.PatientModel;

import javax.swing.*;
import java.util.List;

public class PatientController {

    private PatientModel patientModel;

    public PatientController() {
        patientModel = new PatientModel();
    }

    public String showAllPatients() {
        StringBuilder message = new StringBuilder();
        message.append("......:::::::All Patients:::::::......");
        List<Object> list = patientModel.findAll();
        if (!list.isEmpty()) {
            for (Object object : list) {
                Patient patient = (Patient) object;
                message.append("\nID: ").append(patient.getIdPatient())
                        .append("\nName: ").append(patient.getName())
                        .append("\nLast name: ").append(patient.getLastName())
                        .append("\nBirthDate: ").append(patient.getBirthDate())
                        .append("\nIdentity: ").append(patient.getIdentity())
                        .append("\n");
            }
            return message.toString();
        }
        return message.append("\nThere are no patients in this list").toString();
    }

    public void createPatient() {
        StringBuilder message = new StringBuilder();
        message.append("Patient");

        String name = JOptionPane.showInputDialog(null, "Enter the patient name");
        String lastName = JOptionPane.showInputDialog(null, "Enter the patient last name");
        String birthdate = JOptionPane.showInputDialog(null, "Enter the patient birthdate");
        String identity = JOptionPane.showInputDialog(null, "Enter the patient identity");
        Patient patient = new Patient();
        patient.setName(name);
        patient.setLastName(lastName);
        patient.setBirthDate(birthdate);
        patient.setIdentity(identity);
        patient = (Patient) patientModel.insert(patient);
        if (patient.getIdPatient() != 0) {
            message.append("\nName: ").append(patient.getName())
                    .append("\nLast name: ").append(patient.getLastName())
                    .append("\nIdentity: ").append(patient.getIdentity());
            JOptionPane.showMessageDialog(null, message.toString());
        }
    }

    public void updatePatient() {
        StringBuilder message = new StringBuilder();
        message.append(showAllPatients()).append("\nEnter the id to update");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            Patient patient = (Patient) patientModel.findById(found);
            if (patient != null) {
                String name = JOptionPane.showInputDialog(null, "Enter the patient name", patient.getName());
                String lastName = JOptionPane.showInputDialog(null, "Enter the patient hour", patient.getLastName());
                String birtDate = JOptionPane.showInputDialog(null, "Enter the patient bithdate", patient.getBirthDate());
                String identity = JOptionPane.showInputDialog(null, "Enter the patient identity", patient.getIdentity());

                patient.setName(name);
                patient.setLastName(lastName);
                patient.setBirthDate(birtDate);
                patient.setIdentity(identity);

                if (patientModel.update(patient)) {
                    JOptionPane.showMessageDialog(null, "Patient updated");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Patient doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a number");
        }
    }

    public void deletePatient() {
        StringBuilder message = new StringBuilder();
        message.append(showAllPatients()).append("\nEnter the id to delete");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            if (patientModel.delete(found)) {
                JOptionPane.showMessageDialog(null, "Patient deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Error when eliminating the patient");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "patient doesn't exist");
        }
    }

    public void findPatientByID() {
        StringBuilder message = new StringBuilder();
        message.append("The patient details");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, "\nEnter the id to find"));
            Patient patient = (Patient) patientModel.findById(found);
            if (patient != null){
                message.append("\nID: ").append(patient.getIdPatient())
                        .append("\nName: ").append(patient.getName())
                        .append("\nLast name: ").append(patient.getLastName())
                        .append("\nBirthDate: ").append(patient.getBirthDate())
                        .append("\nIdentity: ").append(patient.getIdentity());

                JOptionPane.showMessageDialog(null,message.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Patient doesn't exist");
        }
    }

    public void findPatientByIdentity() {
        StringBuilder message = new StringBuilder();
        message.append("The patient details");
        try {
            String found = JOptionPane.showInputDialog(null, "\nEnter the id to find");
            Patient patient = (Patient) patientModel.findByIdentity(found);
            if (patient != null){
                message.append("\nID: ").append(patient.getIdPatient())
                        .append("\nName: ").append(patient.getName())
                        .append("\nLast name: ").append(patient.getLastName())
                        .append("\nBirthDate: ").append(patient.getBirthDate())
                        .append("\nIdentity: ").append(patient.getIdentity());

                JOptionPane.showMessageDialog(null,message.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Patient doesn't exist");
        }
    }

}

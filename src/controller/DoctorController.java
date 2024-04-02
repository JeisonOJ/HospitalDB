package controller;

import entity.Doctor;
import entity.Patient;
import model.DoctorModel;

import javax.swing.*;
import java.util.List;

public class DoctorController {

    private DoctorModel doctorModel;

    public DoctorController(){
        doctorModel = new DoctorModel();
    }

    public String showAllDoctors() {
        StringBuilder message = new StringBuilder();
        message.append("......:::::::All Doctors:::::::......");
        List<Object> list = doctorModel.findAll();
        if (!list.isEmpty()) {
            for (Object object : list) {
                Doctor doctor = (Doctor) object;
                message.append("\nID: ").append(doctor.getIdDoctor())
                        .append("\nName: ").append(doctor.getName())
                        .append("\nLast name: ").append(doctor.getLastName())
                        .append("\nSpecialty ID: ").append(doctor.getIdSpecialty())
                        .append("\n");
            }
            return message.toString();
        }
        return message.append("\nThere are no doctors in this list").toString();
    }

    public void createDoctor() {
        StringBuilder message = new StringBuilder();
        message.append("Doctor");

        try{
            String name = JOptionPane.showInputDialog(null, "Enter the doctor name");
            String lastName = JOptionPane.showInputDialog(null, "Enter the doctor last name");
            int specialtyID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the doctor specialtyID"));
            Doctor doctor = new Doctor();
            doctor.setName(name);
            doctor.setLastName(lastName);
            doctor.setIdSpecialty(specialtyID);
            doctor = (Doctor) doctorModel.insert(doctor);
            if (doctor.getIdDoctor() != 0) {
                message.append("\nName: ").append(doctor.getName())
                        .append("\nLast name: ").append(doctor.getLastName())
                        .append("\nSpecialty id: ").append(doctor.getIdSpecialty());
                JOptionPane.showMessageDialog(null, message.toString());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Enter a number");
        }
    }

    public void updateDoctor() {
        StringBuilder message = new StringBuilder();
        message.append(showAllDoctors()).append("\nEnter the id to update");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            Doctor doctor = (Doctor) doctorModel.findById(found);
            if (doctor != null) {
                String name = JOptionPane.showInputDialog(null, "Enter the doctor name", doctor.getName());
                String lastName = JOptionPane.showInputDialog(null, "Enter the doctor hour", doctor.getLastName());
                int specialtyID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the doctor specialtyID",doctor.getIdSpecialty()));

                doctor.setName(name);
                doctor.setLastName(lastName);
                doctor.setIdSpecialty(specialtyID);

                if (doctorModel.update(doctor)) {
                    JOptionPane.showMessageDialog(null, "Doctor updated");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Doctor doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a number");
        }
    }

    public void deleteDoctor() {
        StringBuilder message = new StringBuilder();
        message.append(showAllDoctors()).append("\nEnter the id to delete");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            if (doctorModel.delete(found)) {
                JOptionPane.showMessageDialog(null, "Doctor deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Error when eliminating the doctor");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "doctor doesn't exist");
        }
    }

    public void findDoctorByID() {
        StringBuilder message = new StringBuilder();
        message.append("The doctor details");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, "\nEnter the id to find"));
            Doctor doctor = (Doctor) doctorModel.findById(found);
            if (doctor != null){
                message.append("\nID: ").append(doctor.getIdDoctor())
                        .append("\nName: ").append(doctor.getName())
                        .append("\nLast name: ").append(doctor.getLastName())
                        .append("\nSpecialty id: ").append(doctor.getIdSpecialty());

                JOptionPane.showMessageDialog(null,message.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Doctor doesn't exist");
        }
    }

}

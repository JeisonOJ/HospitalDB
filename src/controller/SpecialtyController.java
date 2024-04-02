package controller;

import entity.Patient;
import entity.Specialty;
import model.SpecialtyModel;

import javax.swing.*;
import java.util.List;

public class SpecialtyController {
    private SpecialtyModel specialtyModel;

    public SpecialtyController(){
        specialtyModel = new SpecialtyModel();
    }

    public String showAllSpecialities() {
        StringBuilder message = new StringBuilder();
        message.append("......:::::::All Specialities:::::::......");
        List<Object> list = specialtyModel.findAll();
        if (!list.isEmpty()) {
            for (Object object : list) {
                Specialty specialty = (Specialty) object;
                message.append("\nID: ").append(specialty.getIdSpecialty())
                        .append("\nName: ").append(specialty.getName())
                        .append("\nLast name: ").append(specialty.getDescription())
                        .append("\n");
            }
            return message.toString();
        }
        return message.append("\nThere are no specialties in this list").toString();
    }

    public void createSpecialty() {
        StringBuilder message = new StringBuilder();
        message.append("Specialty");

        String name = JOptionPane.showInputDialog(null, "Enter the specialty name");
        String description = JOptionPane.showInputDialog(null, "Enter the specialty description");
        Specialty specialty = new Specialty();
        specialty.setName(name);
        specialty.setDescription(description);
        specialty = (Specialty) specialtyModel.insert(specialty);
        if (specialty.getIdSpecialty() != 0) {
            message.append("\nName: ").append(specialty.getName())
                    .append("\nDescription: ").append(specialty.getDescription());
            JOptionPane.showMessageDialog(null, message.toString());
        }
    }

    public void updateSpecialty() {
        StringBuilder message = new StringBuilder();
        message.append(showAllSpecialities()).append("\nEnter the id to update");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            Specialty specialty = (Specialty) specialtyModel.findById(found);
            if (specialty != null) {
                String name = JOptionPane.showInputDialog(null, "Enter the specialty name", specialty.getName());
                String description = JOptionPane.showInputDialog(null, "Enter the specialty description", specialty.getDescription());

                specialty.setName(name);
                specialty.setDescription(description);

                if (specialtyModel.update(specialty)) {
                    JOptionPane.showMessageDialog(null, "Specialty updated");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Specialty doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a number");
        }
    }

    public void deleteSpecialty() {
        StringBuilder message = new StringBuilder();
        message.append(showAllSpecialities()).append("\nEnter the id to delete");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            if (specialtyModel.delete(found)) {
                JOptionPane.showMessageDialog(null, "Specialty deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Error when eliminating the Specialty");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Specialty doesn't exist");
        }
    }

    public void findSpecialtyByID() {
        StringBuilder message = new StringBuilder();
        message.append("The specialty details");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, "\nEnter the id to find"));
            Specialty specialty = (Specialty) specialtyModel.findById(found);
            if (specialty != null){
                message.append("\nID: ").append(specialty.getIdSpecialty())
                        .append("\nName: ").append(specialty.getName())
                        .append("\nDescription: ").append(specialty.getDescription());

                JOptionPane.showMessageDialog(null,message.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Specialty doesn't exist");
        }
    }

}

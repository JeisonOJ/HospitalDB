package controller;

import entity.Appointment;
import model.AppointmentModel;

import javax.swing.*;
import java.util.List;

public class AppointmentController {

    private AppointmentModel appointmentModel;

    public AppointmentController() {
        appointmentModel = new AppointmentModel();
    }

    public String showAllAppointments() {
        StringBuilder message = new StringBuilder();
        message.append("......:::::::All Appointments:::::::......");
        List<Object> list = appointmentModel.findAll();
        if (!list.isEmpty()) {
            for (Object object : list) {
                Appointment appointment = (Appointment) object;
                message.append("\nID: ").append(appointment.getIdAppointment()).append("\nDate: ").append(appointment.getDateAppointment())
                        .append("\nHour: ").append(appointment.getTimeAppointment())
                        .append("\nReason: ").append(appointment.getReason())
                        .append("\nPatient ID: ").append(appointment.getIdPatient())
                        .append("\nDoctor ID: ").append(appointment.getIdDoctor()).append("\n");
            }
            return message.toString();
        }
        return message.append("\nThere are no appointments in this list").toString();
    }

    public void createAppointment() {
        StringBuilder message = new StringBuilder();
        message.append("Appointment");
        try {
            String date = JOptionPane.showInputDialog(null, "Enter the appointment date");
            String time = JOptionPane.showInputDialog(null, "Enter the appointment hour");
            String reason = JOptionPane.showInputDialog(null, "Enter the appointment reason");
            int patient = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter patient ID"));
            int doctor = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter doctor ID"));
            Appointment appointment = new Appointment();
            appointment.setDateAppointment(date);
            appointment.setTimeAppointment(time);
            appointment.setReason(reason);
            appointment.setIdPatient(patient);
            appointment.setIdDoctor(doctor);
            appointment = (Appointment) appointmentModel.insert(appointment);
            if (appointment.getIdAppointment() != 0) {
                message.append("\nDate: ").append(appointment.getDateAppointment())
                        .append("\nHour: ").append(appointment.getTimeAppointment())
                        .append("\nDoctor: ").append(appointment.getIdDoctor());
                JOptionPane.showMessageDialog(null, message.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a number");
        }

    }

    public void updateAppointment() {
        StringBuilder message = new StringBuilder();
        message.append(showAllAppointments()).append("\nEnter the id to update");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            Appointment appointment = (Appointment) appointmentModel.findById(found);
            if (appointment != null) {
                String date = JOptionPane.showInputDialog(null, "Enter the appointment date", appointment.getDateAppointment());
                String time = JOptionPane.showInputDialog(null, "Enter the appointment hour", appointment.getTimeAppointment());
                String reason = JOptionPane.showInputDialog(null, "Enter the appointment reason", appointment.getReason());
                int patient = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter patient ID", appointment.getIdPatient()));
                int doctor = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter doctor ID", appointment.getIdDoctor()));

                appointment.setDateAppointment(date);
                appointment.setTimeAppointment(time);
                appointment.setReason(reason);
                appointment.setIdPatient(patient);
                appointment.setIdDoctor(doctor);

                if (appointmentModel.update(appointment)) {
                    JOptionPane.showMessageDialog(null, "Appointment updated");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Appointment doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Enter a number");
        }
    }

    public void deleteAppointment() {
        StringBuilder message = new StringBuilder();
        message.append(showAllAppointments()).append("\nEnter the id to delete");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, message.toString()));
            if (appointmentModel.delete(found)) {
                JOptionPane.showMessageDialog(null, "Appointment deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Error when eliminating the appointment");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Appointment doesn't exist");
        }
    }

    public void findAnAppointmentByID() {
        StringBuilder message = new StringBuilder();
        message.append("The appointment details");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, "\nEnter the id to find"));
            Appointment appointment = (Appointment) appointmentModel.findById(found);
            if (appointment != null){
                message.append("\nID: ").append(appointment.getIdAppointment())
                        .append("\nDate: ").append(appointment.getDateAppointment())
                        .append("\nHour: ").append(appointment.getTimeAppointment())
                        .append("\nReason: ").append(appointment.getReason())
                        .append("\nPatient: ").append(appointment.getIdPatient())
                        .append("\nDoctor: ").append(appointment.getIdDoctor());

                JOptionPane.showMessageDialog(null,message.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Appointment doesn't exist");
        }
    }
    public void findDoctorByIDDetailed() {
        StringBuilder message = new StringBuilder();
        message.append("The Appointment details");
        try {
            int found = Integer.parseInt(JOptionPane.showInputDialog(null, "\nEnter the id to find"));
            Appointment appointment = (Appointment) appointmentModel.findByIdDetails(found);
            if (appointment != null){
                message.append("\nID: ").append(appointment.getIdAppointment())
                        .append("\nDate: ").append(appointment.getDateAppointment())
                        .append("\nHour: ").append(appointment.getTimeAppointment())
                        .append("\nReason: ").append(appointment.getReason())
                        .append("\nPatient id: ").append(appointment.getPatient().getIdPatient())
                        .append("\nPatient name: ").append(appointment.getPatient().getName())
                        .append("\nPatient last name: ").append(appointment.getPatient().getLastName())
                        .append("\nPatient birthdate: ").append(appointment.getPatient().getBirthDate())
                        .append("\nPatient identity: ").append(appointment.getPatient().getIdentity())
                        .append("\nDoctor id: ").append(appointment.getDoctor().getIdDoctor())
                        .append("\nDoctor name: ").append(appointment.getDoctor().getName())
                        .append("\nDoctor last name: ").append(appointment.getDoctor().getLastName())
                        .append("\nDoctor specialty id: ").append(appointment.getDoctor().getIdSpecialty());

                JOptionPane.showMessageDialog(null,message.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Appointment doesn't exist");
        }
    }

}

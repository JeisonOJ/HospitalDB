import controller.AppointmentController;
import controller.PatientController;
import controller.SpecialtyController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String optionGeneral;
        String message = """
                ....::::::MENU::::::....
                1. Specialty menu.
                2. Doctor menu.
                3. Patient menu.
                4. Appointment menu.
                5. Exit.
                                
                ENTER THE OPTION TO CONTINUE...
                """;

        do {
            optionGeneral = JOptionPane.showInputDialog(null, message);
            if (optionGeneral == null) {
                break;
            }

            switch (optionGeneral) {
                case "1":
                    SpecialtyController specialtyController = new SpecialtyController();
                    String optionSpecialty;
                    String messageSpecialty = """
                            ....::::::SPECIALTY MENU::::::....
                            1. Create a specialty.
                            2. Show all specialties.
                            3. Update a specialty.
                            4. Delete a specialty.
                            5. Find a specialty.
                            6. Exit.
                                            
                            ENTER THE OPTION TO CONTINUE...
                            """;
                    do {
                        optionSpecialty = JOptionPane.showInputDialog(null, messageSpecialty);
                        if (optionSpecialty == null) {
                            break;
                        }
                        switch (optionSpecialty){
                            case "1":
                                specialtyController.createSpecialty();
                                break;
                            case "2":
                                JOptionPane.showMessageDialog(null,specialtyController.showAllSpecialities());
                                break;
                            case "3":
                                specialtyController.updateSpecialty();
                                break;
                            case "4":
                                specialtyController.deleteSpecialty();
                                break;
                            case "5":
                                specialtyController.findSpecialtyByID();
                                break;
                        }
                    } while (!optionSpecialty.equals("6"));
                    break;
                case "2":
                    SpecialtyController doctorController = new SpecialtyController();
                    String optionDoctor;
                    String messageDoctor = """
                            ....::::::SPECIALTY MENU::::::....
                            1. Create a doctor.
                            2. Show all doctors.
                            3. Update a doctor.
                            4. Delete a doctor.
                            5. Find a doctor.
                            6. Exit.
                                            
                            ENTER THE OPTION TO CONTINUE...
                            """;
                    do {
                        optionDoctor = JOptionPane.showInputDialog(null, messageDoctor);
                        if (optionDoctor == null) {
                            break;
                        }
                        switch (optionDoctor){
                            case "1":
                                doctorController.createSpecialty();
                                break;
                            case "2":
                                JOptionPane.showMessageDialog(null,doctorController.showAllSpecialities());
                                break;
                            case "3":
                                doctorController.updateSpecialty();
                                break;
                            case "4":
                                doctorController.deleteSpecialty();
                                break;
                            case "5":
                                doctorController.findSpecialtyByID();
                                break;
                        }
                    } while (!optionDoctor.equals("6"));
                    break;
                case "3":
                    PatientController patientController = new PatientController();
                    String optionPatient;
                    String messagePatient = """
                            ....::::::PATIENT MENU::::::....
                            1. Create a patient.
                            2. Show all patients.
                            3. Update a patient.
                            4. Delete a patient.
                            5. Find a patient.
                            6. Exit.
                                            
                            ENTER THE OPTION TO CONTINUE...
                            """;
                    do {
                        optionPatient = JOptionPane.showInputDialog(null, messagePatient);
                        if (optionPatient == null) {
                            break;
                        }
                        switch (optionPatient){
                            case "1":
                                patientController.createPatient();
                                break;
                            case "2":
                                JOptionPane.showMessageDialog(null,patientController.showAllPatients());
                                break;
                            case "3":
                                patientController.updatePatient();
                                break;
                            case "4":
                                patientController.deletePatient();
                                break;
                            case "5":
                                patientController.findPatientByID();
                                break;
                        }
                    } while (!optionPatient.equals("6"));
                    break;
                case "4":
                    AppointmentController appointmentController = new AppointmentController();
                    String optionAppointment;
                    String messageAppointment = """
                            ....::::::APPOINTMENTS MENU::::::....
                            1. Create an appointment.
                            2. Show all appointments.
                            3. Update an appointment.
                            4. Delete an appointment.
                            5. Find an appointment.
                            6. Exit.
                                            
                            ENTER THE OPTION TO CONTINUE...
                            """;
                    do {
                        optionAppointment = JOptionPane.showInputDialog(null, messageAppointment);
                        if (optionAppointment == null) {
                            break;
                        }
                        switch (optionAppointment){
                            case "1":
                                appointmentController.createAppointment();
                                break;
                            case "2":
                                JOptionPane.showMessageDialog(null,appointmentController.showAllAppointments());
                                break;
                            case "3":
                                appointmentController.updateAppointment();
                                break;
                            case "4":
                                appointmentController.deleteAppointment();
                                break;
                            case "5":
                                appointmentController.findAnAppointmentByID();
                                break;
                        }
                    } while (!optionAppointment.equals("6"));
                    break;
            }

        } while (!optionGeneral.equals("5"));
    }
}
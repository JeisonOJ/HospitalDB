import controller.AppointmentController;
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
                    break;
                case "2":
                    break;
                case "3":
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
                                break;
                            case "5":
                                break;
                        }
                    } while (!optionAppointment.equals("6"));
                    break;
            }

        } while (!optionGeneral.equals("5"));
    }
}
package entity;

public class Appointment {

    private int idAppointment;
    private String dateAppointment;
    private String timeAppointment;
    private String reason;
    private int idPatient;
    private int idDoctor;
    public Appointment(){}
    public Appointment(int idAppointment, String dateAppointment, String timeAppointment, String reason, int idPatient, int idDoctor) {
        this.idAppointment = idAppointment;
        this.dateAppointment = dateAppointment;
        this.timeAppointment = timeAppointment;
        this.reason = reason;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public String getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(String dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public String getTimeAppointment() {
        return timeAppointment;
    }

    public void setTimeAppointment(String timeAppointment) {
        this.timeAppointment = timeAppointment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }
}

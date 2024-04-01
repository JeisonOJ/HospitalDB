package entity;

import java.sql.Date;
import java.sql.Time;

public class Appointment {

    private int idAppointment;
    private Date dateAppointment;
    private Time timeAppointment;
    private String reason;
    private int idPatient;
    private int idDoctor;
    public Appointment(){}
    public Appointment(int idAppointment, Date dateAppointment, Time timeAppointment, String reason, int idPatient, int idDoctor) {
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

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Time getTimeAppointment() {
        return timeAppointment;
    }

    public void setTimeAppointment(Time timeAppointment) {
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

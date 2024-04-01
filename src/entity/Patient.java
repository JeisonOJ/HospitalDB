package entity;

import java.sql.Date;

public class Patient {

    private int idPatient;
    private String name;
    private String lastName;
    private Date birthDate;
    private String identity;

    public Patient(){}

    public Patient(int idPatient, String name, String lastName, Date birthDate, String identity) {
        this.idPatient = idPatient;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.identity = identity;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}

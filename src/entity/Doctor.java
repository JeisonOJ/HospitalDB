package entity;

public class Doctor {
    private int idDoctor;
    private String name;
    private String lastName;
    private int idSpecialty;

    public Doctor(){}

    public Doctor(int idDoctor, String name, String lastName, int idSpecialty) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.lastName = lastName;
        this.idSpecialty = idSpecialty;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
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

    public int getIdSpecialty() {
        return idSpecialty;
    }

    public void setIdSpecialty(int idSpecialty) {
        this.idSpecialty = idSpecialty;
    }
}

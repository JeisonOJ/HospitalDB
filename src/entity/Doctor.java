package entity;

public class Doctor {
    private int idDoctor;
    private String name;
    private String last_name;
    private int idSpecialty;

    public Doctor(){}

    public Doctor(int idDoctor, String name, String last_name, int idSpecialty) {
        this.idDoctor = idDoctor;
        this.name = name;
        this.last_name = last_name;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getIdSpecialty() {
        return idSpecialty;
    }

    public void setIdSpecialty(int idSpecialty) {
        this.idSpecialty = idSpecialty;
    }
}

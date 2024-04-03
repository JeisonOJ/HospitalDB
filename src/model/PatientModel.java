package model;

import database.CRUD;
import database.ConfigDB;
import entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Patient patient = (Patient) object;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO patients(name,last_name,birth_date,identity) VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getBirthDate());
            ps.setString(4, patient.getIdentity());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    patient.setIdPatient(rs.getInt(1));
                    System.out.println("Insert: Patient inserted successfully");
                }
            }
        } catch (SQLException e) {
            System.out.println("Insert: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return patient;
    }

    @Override
    public boolean update(Object object) {
        Patient patient = (Patient) object;
        boolean isUpdated = false;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE patients SET name= ?,last_name = ?, birth_date = ?, identity = ? WHERE id=?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getLastName());
            ps.setString(3, patient.getBirthDate());
            ps.setString(4, patient.getIdentity());
            ps.setInt(5, patient.getIdPatient());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Update: patient update successfully");
                isUpdated = true;
            }

        } catch (SQLException e) {
            System.out.println("Update: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        Connection connection = ConfigDB.openConnection();
        String sql = "DELETE FROM patients WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Delete: patient deleted successfully");
                isDeleted = true;
            }

        } catch (SQLException e) {
            System.out.println("Delete: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return isDeleted;
    }

    @Override
    public List<Object> findAll() {
        List<Object> patients = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM patients";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                patients.add(new Patient(rs.getInt("id"), rs.getString("name"),rs.getString("last_name"), rs.getString("birth_date"), rs.getString("identity")));
            }

        } catch (SQLException e) {
            System.out.println("FindAll: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return patients;
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Patient patient = null;
        String sql = "SELECT * FROM patients WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                patient = new Patient(rs.getInt("id"), rs.getString("name"),rs.getString("last_name"), rs.getString("birth_date"), rs.getString("identity"));
            }

        } catch (SQLException e) {
            System.out.println("FindById: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return patient;
    }
    public Object findByIdentity(String identity) {
        Connection connection = ConfigDB.openConnection();
        Patient patient = null;
        String sql = "SELECT * FROM patients WHERE identity = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, identity);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                patient = new Patient(rs.getInt("id"), rs.getString("name"),rs.getString("last_name"), rs.getString("birth_date"), rs.getString("identity"));
            }

        } catch (SQLException e) {
            System.out.println("FindById: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return patient;
    }

}

package model;

import database.CRUD;
import database.ConfigDB;
import entity.Doctor;
import entity.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Doctor doctor = (Doctor) object;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO doctors(name,last_name,idSpecialty) VALUES (?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getLastName());
            ps.setInt(3, doctor.getIdSpecialty());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    doctor.setIdDoctor(rs.getInt(1));
                    System.out.println("Insert: Doctor inserted successfully");
                }
            }
        } catch (SQLException e) {
            System.out.println("Insert: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return doctor;
    }

    @Override
    public boolean update(Object object) {
        Doctor doctor = (Doctor) object;
        boolean isUpdated = false;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE doctors SET name = ?,last_name = ?, idSpecialty = ? WHERE id=?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getLastName());
            ps.setInt(3, doctor.getIdSpecialty());
            ps.setInt(4, doctor.getIdDoctor());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Update: doctor update successfully");
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
        String sql = "DELETE FROM doctors WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Delete: doctor deleted successfully");
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
        List<Object> doctors = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM doctors";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                doctors.add(new Patient(rs.getInt("id"), rs.getString("name"),rs.getString("last_name"), rs.getString("birth_date"), rs.getString("identity")));
            }

        } catch (SQLException e) {
            System.out.println("FindAll: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return doctors;
    }

    @Override
    public Object findById(int id) {
        return null;
    }
}
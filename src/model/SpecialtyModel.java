package model;

import database.CRUD;
import database.ConfigDB;
import entity.Specialty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Specialty specialty = (Specialty) object;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO specialties(nameSpecialty,description) VALUES (?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, specialty.getName());
            ps.setString(2, specialty.getDescription());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    specialty.setIdSpecialty(rs.getInt(1));
                    System.out.println("Insert: specialty inserted successfully");
                }
            }
        } catch (SQLException e) {
            System.out.println("Insert: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return specialty;
    }

    @Override
    public boolean update(Object object) {
        Specialty specialty = (Specialty) object;
        boolean isUpdated = false;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE specialties SET nameSpecialty = ?,description = ? WHERE id = ?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, specialty.getName());
            ps.setString(2, specialty.getDescription());
            ps.setInt(3, specialty.getIdSpecialty());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Update: specialty update successfully");
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
        String sql = "DELETE FROM specialties where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Delete: specialty deleted successfully");
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
        List<Object> specialties = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM specialties";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                specialties.add(new Specialty(rs.getInt("id"), rs.getString("nameSpecialty"),rs.getString("description")));
            }

        } catch (SQLException e) {
            System.out.println("FindAll: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return specialties;
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Specialty specialty = null;
        String sql = "SELECT * FROM specialties WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                specialty = new Specialty(rs.getInt("id"), rs.getString("nameSpecialty"),rs.getString("description"));
            }

        } catch (SQLException e) {
            System.out.println("FindById: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return specialty;
    }
}

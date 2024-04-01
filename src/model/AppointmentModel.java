package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;

import java.sql.*;
import java.util.List;

public class AppointmentModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Appointment appointment = (Appointment) object;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO appointments(date_appointment,time_appointment,reason,id_patient,id_doctor) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1, appointment.getDateAppointment());
            ps.setTime(2, appointment.getTimeAppointment());
            ps.setString(3, appointment.getReason());
            ps.setInt(4, appointment.getIdPatient());
            ps.setInt(5, appointment.getIdDoctor());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    appointment.setIdAppointment(rs.getInt(1));
                    System.out.println("Insert: Appointment inserted successfully");
                }
            }
        } catch (SQLException e) {
            System.out.println("Insert: error in database\n" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return appointment;
    }

    @Override
    public boolean update(Object object) {
        Appointment appointment = (Appointment) object;
        boolean isUpdated = false;
        Connection connection = ConfigDB.openConnection();
        String sql = "update appointments set date_appointment= ?,time_appointment = ?, reason = ?, id_patient = ?, id_doctor= ? where id=?;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            int rows = ps.executeUpdate();
            if (rows > 0) {

                    System.out.println("Update: Appointment update successfully");

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
        return false;
    }

    @Override
    public List<Object> findAll() {
        return null;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public List<Object> findByName(String name) {
        return null;
    }
}

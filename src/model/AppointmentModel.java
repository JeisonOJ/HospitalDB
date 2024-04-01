package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Appointment appointment = (Appointment) object;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO appointments(date_appointment,time_appointment,reason,id_patient,id_doctor) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, appointment.getDateAppointment());
            ps.setString(2, appointment.getTimeAppointment());
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
            ps.setString(1, appointment.getDateAppointment());
            ps.setString(2, appointment.getTimeAppointment());
            ps.setString(3, appointment.getReason());
            ps.setInt(4, appointment.getIdPatient());
            ps.setInt(5, appointment.getIdDoctor());
            ps.setInt(6, appointment.getIdAppointment());
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
        boolean isDeleted = false;
        Connection connection = ConfigDB.openConnection();
        String sql = "DELETE FROM appointments where id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Delete: Appointment Delete successfully");
            }

        }catch (SQLException e){
            System.out.println("Delete: error in database\n" + e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return isDeleted;
    }

    @Override
    public List<Object> findAll() {
        List<Object> appointments = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM appointments";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                appointments.add(new Appointment(rs.getInt("id"),rs.getString("date_appointment"), rs.getString("time_appointment"), rs.getString("reason"), rs.getInt("id_patient"), rs.getInt("id_doctor")));
            }

        }catch (SQLException e){
            System.out.println("FindAll: error in database\n" + e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return appointments;
    }

    @Override
    public Object findById(int id) {
        Connection connection = ConfigDB.openConnection();
        Appointment appointment = null;
        String sql = "SELECT * FROM appointments WHERE id = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                appointment = new Appointment(rs.getInt("id"),rs.getString("date_appointment"), rs.getString("time_appointment"), rs.getString("reason"), rs.getInt("id_patient"), rs.getInt("id_doctor"));
            }

        }catch (SQLException e){
            System.out.println("FindById: error in database\n" + e.getMessage());
        }finally {
            ConfigDB.closeConnection();
        }
        return appointment;
    }
}

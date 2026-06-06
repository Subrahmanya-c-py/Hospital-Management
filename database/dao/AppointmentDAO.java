package database.dao;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentDAO {

    // BOOK APPOINTMENT
    public void bookAppointment(
            int patientId,
            int doctorId,
            String date) {

        String sql =
                "INSERT INTO appointments(patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, date);

            ps.executeUpdate();

            System.out.println(
                    "Appointment booked successfully!"
            );

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // VIEW APPOINTMENTS
    public void viewAppointments() {

        String sql =
                "SELECT * FROM appointments";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "\n===== APPOINTMENT LIST ====="
            );

            while(rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id") +
                        " | Patient ID: " +
                        rs.getInt("patient_id") +
                        " | Doctor ID: " +
                        rs.getInt("doctor_id") +
                        " | Date: " +
                        rs.getString("appointment_date")
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // SEARCH APPOINTMENT
    public void searchAppointment(int id) {

        String sql =
                "SELECT * FROM appointments WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id") +
                        " | Patient ID: " +
                        rs.getInt("patient_id") +
                        " | Doctor ID: " +
                        rs.getInt("doctor_id") +
                        " | Date: " +
                        rs.getString("appointment_date")
                );

            } else {

                System.out.println(
                        "Appointment not found."
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    // DELETE APPOINTMENT
    public void deleteAppointment(int id) {

        String sql =
                "DELETE FROM appointments WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Appointment deleted successfully!"
                );

            } else {

                System.out.println(
                        "Appointment not found."
                );
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}
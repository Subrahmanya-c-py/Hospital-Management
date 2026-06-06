package database.dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Doctor;

public class DoctorDAO {

    // ADD DOCTOR
    public void addDoctor(Doctor doctor) {

        String sql =
                "INSERT INTO doctors(name, specialization) VALUES (?, ?)";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());

            ps.executeUpdate();

            System.out.println(
                    "Doctor added successfully!"
            );

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }

    // VIEW DOCTORS
    public void viewDoctors() {

        String sql =
                "SELECT * FROM doctors";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println("\n===== DOCTOR LIST =====");

            while(rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id") +
                        " | Name: " + rs.getString("name") +
                        " | Specialization: " +
                        rs.getString("specialization")
                );
            }

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }

    // SEARCH DOCTOR
    public void searchDoctor(int id) {

        String sql =
                "SELECT * FROM doctors WHERE id=?";

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
                        " | Name: " + rs.getString("name") +
                        " | Specialization: " +
                        rs.getString("specialization")
                );

            } else {

                System.out.println(
                        "Doctor not found."
                );
            }

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }

    // UPDATE DOCTOR
    public void updateDoctor(
            int id,
            String name,
            String specialization) {

        String sql =
                "UPDATE doctors SET name=?, specialization=? WHERE id=?";

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.setInt(3, id);

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Doctor updated successfully!"
                );

            } else {

                System.out.println(
                        "Doctor not found."
                );
            }

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }

    // DELETE DOCTOR
    public void deleteDoctor(int id) {

        String sql =
                "DELETE FROM doctors WHERE id=?";

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
                        "Doctor deleted successfully!"
                );

            } else {

                System.out.println(
                        "Doctor not found."
                );
            }

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }
}
package database.dao;

import database.DBConnection;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientDAO {

    public void addPatient(Patient patient) {

        String sql =
                "INSERT INTO patients(name, age, disease) VALUES (?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getDisease());

            ps.executeUpdate();

            System.out.println(
                    "Patient inserted into database!"
            );

            con.close();

        }

        catch(Exception e) {

            e.printStackTrace();
        }
    }
    public void viewPatients() {

    String sql = "SELECT * FROM patients";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        var rs = ps.executeQuery();

        System.out.println("\n===== PATIENT LIST =====");

        while (rs.next()) {

            System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Age: " + rs.getInt("age") +
                    " | Disease: " + rs.getString("disease")
            );
        }

        con.close();

    }

    catch(Exception e) {

        e.printStackTrace();
    }
}
public void searchPatient(int id) {

    String sql =
            "SELECT * FROM patients WHERE id = ?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);

        var rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Age: " + rs.getInt("age") +
                    " | Disease: " + rs.getString("disease")
            );

        } else {

            System.out.println("Patient not found.");
        }

        con.close();

    }

    catch(Exception e) {

        e.printStackTrace();
    }
}

public void updatePatient(int id,
                          String name,
                          int age,
                          String disease) {

    String sql =
            "UPDATE patients SET name=?, age=?, disease=? WHERE id=?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, disease);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {
            System.out.println("Patient updated successfully!");
        }
        else {
            System.out.println("Patient not found.");
        }

        con.close();

    } catch(Exception e) {

        e.printStackTrace();
    }
}

public void deletePatient(int id) {

    String sql =
            "DELETE FROM patients WHERE id=?";

    try {

        Connection con =
                DBConnection.getConnection();

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if(rows > 0) {

            System.out.println(
                    "Patient deleted successfully!"
            );

        } else {

            System.out.println(
                    "Patient not found."
            );
        }

        con.close();

    }

    catch(Exception e) {

        e.printStackTrace();
    }
}


}
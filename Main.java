import database.DBConnection;
import database.dao.AppointmentDAO;
import database.dao.DoctorDAO;
import database.dao.PatientDAO;
import java.util.Scanner;
import model.*;
import service.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DBConnection.getConnection();
       
       
        AdminService adminService = new AdminService();
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        

        if (!adminService.login(sc)) {
            System.out.println("Access Denied. Exiting...");
            return;
        }


        while (true) {
            printMenu();
            int choice = readInt("Choose option: ");

            switch (choice) {
                case 1 -> addPatient(patientDAO);
                case 2 -> patientDAO.viewPatients();
                case 3 -> addDoctor(doctorDAO);
                case 4 -> doctorDAO.viewDoctors();
                case 5 -> bookAppointment(appointmentDAO);
                case 6 -> appointmentDAO.viewAppointments();
                case 7 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                case 8 -> searchPatient(patientDAO);
                case 9 -> updatePatient(patientDAO);
                case 10 -> deletePatient(patientDAO);
                case 11 -> searchDoctor(doctorDAO);
                case 12 -> updateDoctor(doctorDAO);
                case 13 -> deleteDoctor(doctorDAO);
                case 14 -> searchAppointment(appointmentDAO);
                case 15 -> deleteAppointment(appointmentDAO);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== Hospital Management System =====");
        System.out.println("""
                1. Add Patient
                2. View Patients
                3. Add Doctor
                4. View Doctors
                5. Book Appointment
                6. View Appointments
                7. Exit
                8. Search Patient
                9. Update Patient
                10. Delete Patient
                11. Search Doctor
                12. Update Doctor
                13. Delete Doctor
                14. Search Appointment
                15. Delete Appointment
                """);
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter numbers only." + e);
            }
        }
    }
private static void addPatient(PatientDAO dao) {

    int id = readInt("Enter Patient ID: ");

    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    int age = readInt("Enter Age: ");

    System.out.print("Enter Disease: ");
    String disease = sc.nextLine();

    dao.addPatient(
            new Patient(
                    id,
                    name,
                    age,
                    disease
            )
    );
}

 private static void addDoctor(DoctorDAO dao) {

    int id =
            readInt("Enter Doctor ID: ");

    System.out.print("Enter Name: ");
    String name = sc.nextLine();

    System.out.print("Enter Specialization: ");
    String spec = sc.nextLine();

    dao.addDoctor(
            new Doctor(
                    id,
                    name,
                    spec
            )
    );
}
    private static void bookAppointment(
        AppointmentDAO dao) {

    int patientId =
            readInt("Enter Patient ID: ");

    int doctorId =
            readInt("Enter Doctor ID: ");

    System.out.print("Enter Date: ");
    String date =
            sc.nextLine();

    dao.bookAppointment(
            patientId,
            doctorId,
            date
    );
}

    

   private static void updatePatient(PatientDAO dao) {

    int id =
            readInt("Enter Patient ID to update: ");

    System.out.print("Enter New Name: ");
    String name = sc.nextLine();

    int age =
            readInt("Enter New Age: ");

    System.out.print("Enter New Disease: ");
    String disease = sc.nextLine();

    dao.updatePatient(
            id,
            name,
            age,
            disease
    );
}
    private static void deletePatient(PatientDAO dao) {

    int id =
            readInt("Enter Patient ID to delete: ");

    dao.deletePatient(id);
}
    
    private static void searchPatient(PatientDAO dao) {

    int id =
            readInt("Enter Patient ID to search: ");

    dao.searchPatient(id);
}

private static void searchDoctor(DoctorDAO dao) {

    int id =
            readInt("Enter Doctor ID: ");

    dao.searchDoctor(id);
}

private static void updateDoctor(DoctorDAO dao) {

    int id =
            readInt("Enter Doctor ID: ");

    System.out.print("Enter New Name: ");
    String name = sc.nextLine();

    System.out.print("Enter New Specialization: ");
    String specialization = sc.nextLine();

    dao.updateDoctor(
            id,
            name,
            specialization
    );
}

private static void deleteDoctor(DoctorDAO dao) {

    int id =
            readInt("Enter Doctor ID: ");

    dao.deleteDoctor(id);
}

private static void searchAppointment(
        AppointmentDAO dao) {

    int id =
            readInt("Enter Appointment ID: ");

    dao.searchAppointment(id);
}

private static void deleteAppointment(
        AppointmentDAO dao) {

    int id =
            readInt("Enter Appointment ID: ");

    dao.deleteAppointment(id);
}
}
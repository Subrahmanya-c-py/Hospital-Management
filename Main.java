import java.util.Scanner;
import model.*;
import service.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();
        AdminService adminService = new AdminService();

        if (!adminService.login(sc)) {
            System.out.println("Access Denied. Exiting...");
            return;
        }

        while (true) {
            printMenu();
            int choice = readInt("Choose option: ");

            switch (choice) {
                case 1 -> addPatient(patientService);
                case 2 -> patientService.viewPatients();
                case 3 -> addDoctor(doctorService);
                case 4 -> doctorService.viewDoctors();
                case 5 -> bookAppointment(appointmentService);
                case 6 -> appointmentService.viewAppointments();
                case 7 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                case 8 -> searchPatient(patientService);
                case 9 -> updatePatient(patientService);
                case 10 -> deletePatient(patientService);
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

    private static void addPatient(PatientService service) {
        int id = readInt("Enter Patient ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        int age = readInt("Enter Age: ");
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        service.addPatient(new Patient(id, name, age, disease));
    }

    private static void addDoctor(DoctorService service) {
        int id = readInt("Enter Doctor ID: ");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String spec = sc.nextLine();

        service.addDoctor(new Doctor(id, name, spec));
    }

    private static void bookAppointment(AppointmentService service) {
        int pid = readInt("Enter Patient ID: ");
        int did = readInt("Enter Doctor ID: ");
        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        service.bookAppointment(new Appointment(pid, did, date));
    }

    private static void searchPatient(PatientService service) {
        int id = readInt("Enter Patient ID to search: ");
        Patient p = service.searchPatient(id);
        System.out.println(p != null ? p : "Patient not found.");
    }

    private static void updatePatient(PatientService service) {
        int id = readInt("Enter Patient ID to update: ");
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        int age = readInt("Enter New Age: ");
        System.out.print("Enter New Disease: ");
        String disease = sc.nextLine();

        service.updatePatient(id, name, age, disease);
    }

    private static void deletePatient(PatientService service) {
        int id = readInt("Enter Patient ID to delete: ");
        service.deletePatient(id);
    }
}
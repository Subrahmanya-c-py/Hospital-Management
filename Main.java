import java.util.Scanner;
import model.*;
import service.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
        AppointmentService appointmentService = new AppointmentService();
        AdminService adminService = new AdminService();


        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.println("8. Search Patient");
            System.out.println("9. Update Patient");
            System.out.println("10. Delete Patient");

            System.out.print("Choose option: ");

            int choice;

        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Enter numbers only.");
        continue;
    }

            
        if (!adminService.login(sc)) {
            System.out.println("Access Denied. Exiting...");
        return;
    }


            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    patientService.addPatient(
                        new Patient(pid, pname, age, disease)
                    );
                    break;

                case 2:
                    patientService.viewPatients();
                    break;

                case 3:
                    System.out.print("Enter Doctor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();

                    doctorService.addDoctor(
                        new Doctor(did, dname, spec)
                    );
                    break;

                case 4:
                    doctorService.viewDoctors();
                    break;

                case 5:
                    System.out.print("Enter Patient ID: ");
                    int apid = sc.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int adid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();

                    appointmentService.bookAppointment(
                        new Appointment(apid, adid, date)
                    );
                    break;

                case 6:
                    appointmentService.viewAppointments();
                    break;

                case 7:
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
                case 8:
                    System.out.print("Enter Patient ID to search: ");
                    int sid = sc.nextInt();
                    Patient sp = patientService.searchPatient(sid);
                    if (sp != null) {
                    System.out.println(sp);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 9:
                    System.out.print("Enter Patient ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int uage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Disease: ");
                    String udisease = sc.nextLine();
                    patientService.updatePatient(uid, uname, uage, udisease);
                    break;
                case 10:
                    System.out.print("Enter Patient ID to delete: ");
                    int id = sc.nextInt();
                    patientService.deletePatient(id);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

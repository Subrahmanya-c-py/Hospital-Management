package service;

import java.util.Scanner;

public class AdminService {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public boolean login(Scanner sc) {

        System.out.println("========== ADMIN LOGIN ==========");
        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            System.out.println("Login successful!\n");
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }
}
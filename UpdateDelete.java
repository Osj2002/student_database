import java.sql.*;
import java.util.Scanner;

public class UpdateDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "DB_Password";  

        try (Connection con = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Choose an option:");
            System.out.println("1. Update Student");
            System.out.println("2. Delete Student");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter Student ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                String updateSql = "UPDATE students SET name = ?, GPA = ?, Department = ?, age = ?, year = ? WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(updateSql)) {

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new GPA (e.g., 3.75): ");
                    double newGPA = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter new Department: ");
                    String newDept = scanner.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();

                    System.out.print("Enter new year: ");
                    int newYear = scanner.nextInt();

                    pstmt.setString(1, newName);
                    pstmt.setDouble(2, newGPA);
                    pstmt.setString(3, newDept);
                    pstmt.setInt(4, newAge);
                    pstmt.setInt(5, newYear);
                    pstmt.setInt(6, id);

                    int updated = pstmt.executeUpdate();
                    System.out.println(updated + " record(s) updated.");
                }

            } else if (choice == 2) {
                System.out.print("Enter Student ID to delete: ");
                int id = scanner.nextInt();

                String deleteSql = "DELETE FROM students WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(deleteSql)) {
                    pstmt.setInt(1, id);

                    int deleted = pstmt.executeUpdate();
                    System.out.println(" record deleted.");
                }

            } else {
                System.out.println("Invalid choice......");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


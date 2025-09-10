import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) {
        // credentials to make the connection
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "0987@Snowy";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             Scanner sc = new Scanner(System.in)) {

            System.out.println("No of students:");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++) {
                System.out.println("Student " + i + ":");
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter GPA: ");
                double gpa = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Department: ");
                String dept = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("ENter Year: ");
                int year = sc.nextInt();
                sc.nextLine();

                String sql = "INSERT INTO students (name, GPA, Department, age, year) VALUES ('"
                        + name + "', " + gpa + ", '" + dept + "', " + age + ", " + year + ")";

                int rows = stmt.executeUpdate(sql);
                System.out.println(" Records inserted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

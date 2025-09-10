import java.sql.*;

public class CheckConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "DB_PASSWORD";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create a connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully!");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}



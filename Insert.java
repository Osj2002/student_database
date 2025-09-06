
import java.sql.*;

public class Insert {
    public static void main(String[] args){
        //credentials to make the connection
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "DB_PASSWORD";

        try(Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement()){

            // input data to the student_database table
            String sql = "INSERT INTO students (name, GPA,Department,age,year) VALUES "
                    + "('Jone', 3.1,'Chemistry',22,1), "
                    + "('Alice', 2.9,'Maths',23,4), "
                    + "('Bob', 3.8,'Statistics',21,3)";
            int rows= stmt.executeUpdate(sql);

            System.out.println("Records inserted");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

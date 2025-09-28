package banking;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/banking_system";
    private static final String USER = "root"; // change if you set another username
    private static final String PASSWORD = "your_password_here"; // replace with your MySQL password

    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver (optional for modern versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Return connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

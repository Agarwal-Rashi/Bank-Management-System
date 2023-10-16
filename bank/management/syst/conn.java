package bank.management.syst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement; // Import java.sql.Statement

public class conn {
    Connection connection;
    Statement statement;

    public conn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "20032003****");
            statement = connection.createStatement(); // Use java.sql.Statement
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String q) {
        try {
            return connection.prepareStatement(q);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

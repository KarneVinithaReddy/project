package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForgotPasswordDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank_servletdb";
    private static final String USER = "root";
    private static final String PASS = "root";

    public int updatePassword(String email, String newPassword) throws SQLException {
        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement("UPDATE user SET pwd = ? WHERE email = ?");
        
        ps.setString(1, newPassword);
        ps.setString(2, email);
        
        int result = ps.executeUpdate();
        
        ps.close();
        con.close();
        
        return result;
    }
}

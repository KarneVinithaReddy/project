package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.cj.jdbc.Driver;

import bank.dto.Registration;

public class RegistrationDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank_servletdb?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASS = "root";

    static {
        try {
            new Driver();
        } catch (SQLException e) {
            System.out.println("Error loading driver: " + e.getMessage());
        }
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS user (" +
            "firstname VARCHAR(45), " +
            "lastname VARCHAR(45), " +
            "email VARCHAR(45) UNIQUE, " +
            "pwd VARCHAR(45), " +
            "confirmpwd VARCHAR(45), " +
            "address VARCHAR(100), " +
            "gender VARCHAR(10), " +
            "nationality VARCHAR(20), " +
            "phone BIGINT(10), " +
            "age INT, " +
            "dob DATE)";

    public void createTableForBankUser() throws SQLException {
        try (Connection con = createConnection(); Statement s = con.createStatement()) {
            s.execute(CREATE_TABLE_QUERY);
        }
    }

    private static final String SAVE_USER_QUERY = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public int saveUser(Registration registration) throws SQLException {
        createTableForBankUser();
        try (Connection con = createConnection(); PreparedStatement ps = con.prepareStatement(SAVE_USER_QUERY)) {
            ps.setString(1, registration.getFirstname());
            ps.setString(2, registration.getLastname());
            ps.setString(3, registration.getEmail());
            ps.setString(4, registration.getPwd());
            ps.setString(5, registration.getConfirmpwd());
            ps.setString(6, registration.getAddress());
            ps.setString(7, registration.getGender());
            ps.setString(8, registration.getNationality());
            ps.setLong(9, registration.getPhone());
            ps.setInt(10, registration.getAge());
            ps.setObject(11, registration.getDob());
            return ps.executeUpdate();
        }
    }

    private static final String UPDATE_PASSWORD_QUERY = "UPDATE user SET pwd = ? WHERE email = ?";

    public int updatePassword(String email, String newPassword) throws SQLException {
        try (Connection con = createConnection(); PreparedStatement ps = con.prepareStatement(UPDATE_PASSWORD_QUERY)) {
            ps.setString(1, newPassword);
            ps.setString(2, email);
            return ps.executeUpdate();
        }
    }
}


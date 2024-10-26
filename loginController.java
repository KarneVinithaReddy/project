package bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/login")
public class loginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");

        if (pwd == null || pwd.isEmpty()) {
            req.setAttribute("msg", "Please enter your password!...");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.include(req, resp);
            return;
        }

        try {
            // Load and register driver
            DriverManager.registerDriver(new Driver());

            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_servletdb?createDatabaseIfNotExist=true", "root", "root");

            // Create prepared statement
            PreparedStatement ps = con.prepareStatement("SELECT pwd FROM user WHERE email = ?");

            ps.setString(1, email);

            // Execute query
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                // Retrieve stored password
                String storedPwd = res.getString("pwd");

                // Check if stored password is not null
                if (storedPwd != null) {
                    // Compare input password with stored password
                    if (pwd.equals(storedPwd)) {
                        System.out.println("Login successful!");

                        // Create session
                        HttpSession session = req.getSession();
                        session.setAttribute("email", email);

                        // Forward to home page
                        RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
                        dispatcher.forward(req, resp);
                    } else {
                        req.setAttribute("msg", "Invalid Password!...");
                        System.out.println("Invalid password");

                        // Forward back to login page
                        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                        dispatcher.include(req, resp);
                    }
                } else {
                    req.setAttribute("msg", "Password not found!...");
                    System.out.println("Password not found");

                    // Forward back to login page
                    RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                    dispatcher.include(req, resp);
                }
            } else {
                req.setAttribute("msg", "Invalid Email!...");
                System.out.println("Invalid email");

                // Forward back to login page
                RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                dispatcher.include(req, resp);
            }

            // Close resources
            res.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            req.setAttribute("msg", "Database error!...");
            System.out.println("Database error: " + e.getMessage());

            // Forward back to login page
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.include(req, resp);
        }
    }
}

package bank.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.RegistrationDao;

@WebServlet("/forgot")
public class ForgotPasswordController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String newPassword = req.getParameter("newPassword");
        String confirmPassword = req.getParameter("confirmPassword");

        try {
            if (newPassword.equals(confirmPassword)) {
                RegistrationDao dao = new RegistrationDao();
                int result = dao.updatePassword(email, newPassword);

                if (result > 0) {
                    resp.getWriter().println("Password updated successfully!");
                } else {
                    resp.getWriter().println("Failed to update password! Please check your email.");
                }
            } else {
                resp.getWriter().println("Passwords do not match!");
            }
        } catch (SQLException e) {
            resp.getWriter().println("Database error: " + e.getMessage());
        }
    }
}



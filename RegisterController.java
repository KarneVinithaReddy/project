
package bank.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.RegistrationDao;
import bank.dto.Registration;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String confirmpwd = req.getParameter("confirmpwd");
        String address = req.getParameter("address");
        String gender = req.getParameter("gender");
        String nationality = req.getParameter("nationality");
        String phone = req.getParameter("phone");
        String age = req.getParameter("age");
        String dob = req.getParameter("dob"); // Changed from "DOB" to "dob"

        RegistrationDao dao = new RegistrationDao();
        Registration registration = null;
        try {
            registration = new Registration(
                    firstname, 
                    lastname, 
                    email, 
                    pwd, 
                    confirmpwd, 
                    address, 
                    gender, 
                    nationality, 
                    Long.parseLong(phone), 
                    Integer.parseInt(age), 
                    LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd")) // Added DateTimeFormatter
            );
        } catch (DateTimeParseException e) {
            resp.getWriter().println("Error: Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        try {
            int result = dao.saveUser(registration);
            if (result > 0) {
                resp.getWriter().println("Registration successful!");
                RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
                rd.forward(req,resp);
            } else {
                resp.getWriter().println("Registration failed!");
            }
        } catch (Exception e) {
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}


 
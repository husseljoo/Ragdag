package com.example.ragdag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("password2");
        String role = request.getParameter("role");

        if (role.equals("emp")) {
            response.getWriter().println("The guy is an employee");
        } else if (role.equals("man")) {
            response.getWriter().println("The guy is a manager");
        }




        try {
            Connection con = DatabaseConnection.initializeDatabase();


            String query = "INSERT INTO Users (first_name, last_name, username, email, password, role) VALUES (?,?,?,?,?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1,firstName);
            preparedStmt.setString (2,lastName);
            preparedStmt.setString (3,username);
            preparedStmt.setString (4,email);
            preparedStmt.setString (5,password);
            preparedStmt.setString (6,role);

            // execute the preparedstatement
            preparedStmt.execute();
            con.close();

            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } catch(SQLIntegrityConstraintViolationException e){
           //username already exists in database not unique
        } catch (Exception e) {
            e.printStackTrace();
        }

//        response.getWriter().println("First Name is"+firstName);
//        response.getWriter().println("Last Name is"+lastName);
//        response.getWriter().println("Username is "+username);
//        response.getWriter().println("Email is "+email);
//        response.getWriter().println("Password is "+password);
//        response.getWriter().println("Retyped password is "+retypePassword);

    }
}

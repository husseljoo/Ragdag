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
        response.getWriter().println("This is inside the post method");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("password2");
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("last");


        response.getWriter().println("First Name is"+firstName);
        response.getWriter().println("Last Name is"+lastName);
        response.getWriter().println("Username is "+username);
        response.getWriter().println("Email is "+email);
        response.getWriter().println("Password is "+password);
        response.getWriter().println("Retyped password is "+retypePassword);

        try {
            Connection con = DatabaseConnection.initializeDatabase();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Users");
            while(rs.next())
                response.getWriter().println(rs.getInt(0)+"  "+rs.getString(1)+"  "+rs.getString(2));

            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

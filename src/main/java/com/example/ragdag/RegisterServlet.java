package com.example.ragdag;

import Helpers.DatabaseConnection;
import Helpers.QueryProcessor;
import Helpers.QueryType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        Connection connection = null;

        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO Users (first_name, last_name, username, email, password, role) VALUES (?,?,?,?,?,?)";
        List<String> parameters = new ArrayList<String>();
        parameters.add(firstName);
        parameters.add(lastName);
        parameters.add(username);
        parameters.add(email);
        parameters.add(password);
        parameters.add(role);

        QueryType queryType = QueryType.INSERT;

        QueryProcessor queryProcessor = new QueryProcessor(connection, query, parameters, queryType);
        ResultSet resultSet = queryProcessor.execute();

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
    }
}

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

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Connection connection = null;
        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String query = "SELECT id, role, first_name FROM Users WHERE username=? AND password=?";
        List<String> parameters = new ArrayList<String>();
        parameters.add(username);
        parameters.add(password);
        QueryType queryType = QueryType.SELECT;

        QueryProcessor queryProcessor = new QueryProcessor(connection, query, parameters, queryType);
        ResultSet resultSet = queryProcessor.execute();

        Integer idVal = null;
        String role = null;
        String firstName = null;

        try {
            resultSet.next();
            idVal = resultSet.getInt("id");
            role = resultSet.getString("role");
            firstName = resultSet.getString("first_name");
            System.out.println("The retrieved value from ResultSet is: " + idVal);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("username and password combination does not exist");
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("id", idVal);
        session.setAttribute("role", role);
        session.setAttribute("first_name", firstName);

        response.sendRedirect("Home.jsp");
    }
}
package com.example.ragdag;

import Helpers.DatabaseConnection;
import Helpers.QueryProcessor;
import Helpers.QueryType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddCarServlet", value = "/AddCarServlet")
public class AddCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String year = request.getParameter("year");
        String color = request.getParameter("color");
        String country = request.getParameter("country");


        Connection connection = null;

        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO Cars (brand, model, year, color, country) VALUES (?,?,?,?,?)";
        List<String> parameters = new ArrayList<String>();
        parameters.add(brand);
        parameters.add(model);
        parameters.add(year);
        parameters.add(color);
        parameters.add(country);
        QueryType queryType = QueryType.INSERT;

        QueryProcessor queryProcessor = new QueryProcessor(connection, query, parameters, queryType);
        queryProcessor.execute();

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("CarsServlet");
    }
}

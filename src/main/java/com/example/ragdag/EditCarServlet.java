package com.example.ragdag;

import Helpers.DatabaseConnection;
import Helpers.QueryProcessor;
import Helpers.QueryType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditCarServlet", value = "/EditCarServlet")
public class EditCarServlet extends HttpServlet {
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

        System.out.println("UPDATE Cars SET brand=?, model=?, year=?, color=?, country=? WHERE id=?");
        System.out.println("the supposed id of the car is: " + request.getParameter("edit_car"));
        String query = "UPDATE Cars SET brand=?, model=?, year=?, color=?, country=? WHERE id=?";
        List<String> parameters = new ArrayList<String>();
        parameters.add(brand);
        parameters.add(model);
        parameters.add(year);
        parameters.add(color);
        parameters.add(country);
        parameters.add(request.getParameter("edit_car"));
        QueryType queryType = QueryType.UPDATE;

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
























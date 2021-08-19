package com.example.ragdag;

import Helpers.DatabaseConnection;
import Helpers.QueryProcessor;
import Helpers.QueryType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RemoveServlet", value = "/RemoveServlet")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String remove = request.getParameter("remove_car");
        String edit = request.getParameter("edit_car");
        String carId = null;

        if(remove==null && edit==null) {
           return;
        } else if(remove==null && edit!=null) {
            carId = edit;
        } else if(remove!=null && edit==null) {
            carId = remove;
        }

        Connection connection = null;
        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "DELETE FROM Cars WHERE id=?";
        List<String> parameters = new ArrayList<String>();
        parameters.add(carId);
        QueryType queryType = QueryType.DELETE;

        QueryProcessor queryProcessor = new QueryProcessor(connection, query, parameters, queryType);
        queryProcessor.execute();
        System.out.println("The car with id" + carId + " has been deleted");

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("CarsServlet");
    }
}

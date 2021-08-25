package com.example.ragdag;

import Helpers.Car;
import Helpers.DatabaseConnection;
import Helpers.QueryProcessor;
import Helpers.QueryType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarsServlet", value = "/CarsServlet")
public class CarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        Connection connection = null;
        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String query = "SELECT * FROM Cars C INNER JOIN Country L ON C.country = L.country_code";
        List<String> parameters = new ArrayList<String>();
        QueryType queryType = QueryType.SELECT;

        QueryProcessor queryProcessor = new QueryProcessor(connection, query, parameters, queryType);
        ResultSet resultSet = queryProcessor.execute();

        List<Car> carsList = new ArrayList<Car>();
        try {
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                Integer year = resultSet.getInt("year");
                String color = resultSet.getString("color");
                String country = resultSet.getString("name"); //Country.name not Cars.country
                String countryCode = resultSet.getString("country_code"); //Country.name not Cars.country
                Car car = new Car(id, brand, model, year, color, country, countryCode);
                carsList.add(car);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        request.setAttribute("cars_list", carsList);
        if(role.equals("emp"))
            request.getRequestDispatcher("CarsEmp.jsp").forward(request, response);
        else if(role.equals("man"))
            request.getRequestDispatcher("CarsManager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

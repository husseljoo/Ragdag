package com.example.ragdag;

import Helpers.*;

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
    public void init() throws ServletException {
//        super.init();
//        try {
//            connection = DatabaseConnection.initializeDatabase();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return;
//        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        //produce result set
        String query = "SELECT * FROM Cars C INNER JOIN Country L ON C.country = L.country_code";
        List<String> parameters = new ArrayList<String>();
        QueryType queryType = QueryType.SELECT;
        ResultSet resultSet =  new QueryProcessor(connection, query, parameters, queryType).execute();

        //produce cars list to pass it to Car.jsp
        List<Car> carsList = new CarsList(resultSet).execute();

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
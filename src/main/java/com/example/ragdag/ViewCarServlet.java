package com.example.ragdag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewCarServlet", value = "/ViewCarServlet")
public class ViewCarServlet extends HttpServlet {
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


        request.setAttribute("brand", brand);
        request.setAttribute("model", model);
        request.setAttribute("year", year);
        request.setAttribute("color", color);
        request.setAttribute("country", country);

        request.getRequestDispatcher("ViewCar.jsp").forward(request, response);


    }
}

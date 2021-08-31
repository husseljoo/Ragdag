package com.example.ragdag;

import Helpers.Config;
import Helpers.DatabaseConnection;
import Helpers.QueryProcessor;
import Helpers.QueryType;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet(name = "EditCarServlet", value = "/EditCarServlet")
public class EditCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String carId = request.getParameter("edit_car");
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String year = request.getParameter("year");
        String color = request.getParameter("color");
        String country = request.getParameter("country");

        Part imagePart = request.getPart("upload_image");
        InputStream inputStream = imagePart.getInputStream();
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        String imagePath = Config.IMAGE_PATH+"/"+carId+".jpg";
        File imageFile = new File(imagePath);
        Boolean bool = ImageIO.write(bufferedImage, "jpg", imageFile);

        if(!bool)
            System.out.println("Image write failed my G!");
        else
            System.out.println("The image write succeeded!");




//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        Image  image = ImageIO.read(inputStream);
//        String path =request.getContextPath()+"/images/";
//        File file = new File(path);
//        ImageIO.write((RenderedImage) image, "jpg", file);

        Connection connection = null;

        try {
            connection = DatabaseConnection.initializeDatabase();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

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
package com.example.ragdag;

import Helpers.Config;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "ImageServlet", value = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carId = request.getParameter("carId");
        String imagePath = Config.IMAGE_PATH+"/"+carId+".jpg";

        response.setContentType("image/jpg");
        ServletOutputStream out;
        out = response.getOutputStream();
        FileInputStream fin = new FileInputStream(imagePath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch;
        while((ch=bin.read())!=-1){
            bout.write(ch);
        }
        bin.close();
        fin.close();
        bout.close();
        out.close();

//        request.setAttribute("imageServlet", "-"); //"-" to see that it is not null
//        request.getRequestDispatcher("ViewCar.jsp").forward(request, response);
    }

}
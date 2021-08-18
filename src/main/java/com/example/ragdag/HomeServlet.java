package com.example.ragdag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("id");

        try {
            Connection con = DatabaseConnection.initializeDatabase();
            String query = "SELECT first_name FROM Users WHERE id=?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,id.toString());

            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
            try{
                rs.next();
                String firstName = rs.getString(1);
                response.getWriter().println("The first name of the user is "+firstName);
                System.out.println("The first name of the user is "+firstName);
            } catch(Exception e){
                System.out.println("username and password combination does not exist");
                //redirect to invalid login jsp
                return;
            }
            con.close();

//            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } catch(SQLIntegrityConstraintViolationException e){
            //username already exists in database not unique
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
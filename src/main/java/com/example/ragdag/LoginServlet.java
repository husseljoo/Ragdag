package com.example.ragdag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.getWriter().println("Username is: "+username);
        response.getWriter().println("Password is: "+password);

        Integer idVal = null;
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            String query = " SELECT id FROM Users WHERE username=? AND password=? ";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,username);
            preparedStmt.setString(2,password);

            // execute the preparedstatement
            ResultSet rs = preparedStmt.executeQuery();
            try{
                rs.next();
                idVal = rs.getInt(1);
                response.getWriter().println("The retrieved value from ResultSet is: "+idVal);
                System.out.println("The retrieved value from ResultSet is: "+idVal);
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

        HttpSession session = request.getSession();
        session.setAttribute("id", idVal);
        response.sendRedirect("HomeServlet");

//        response.getWriter().println("Session ID: " + session.getId());
//        response.getWriter().println("Creation Time: " + new Date(session.getCreationTime()));
//        response.getWriter(). println("Last Accessed Time: " + new Date(session.getLastAccessedTime()));

    }
//        response.sendRedirect("testRedirect.html");
//        response.getWriter().append("<script>alert(\"I'm here!\")</script>");
}
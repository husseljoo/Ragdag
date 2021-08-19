package Helpers;

import Helpers.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        try {
            Connection con = DatabaseConnection.initializeDatabase();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }

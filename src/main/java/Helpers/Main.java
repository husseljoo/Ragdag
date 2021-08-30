package Helpers;

import Helpers.DatabaseConnection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
//        Car car = new Car("12","hiefg",);
        Class carClass= Car.class;
        Constructor[] constList = carClass.getConstructors();
//         carClass.getConstructors();
        Constructor cons = carClass.getConstructors()[0];
        System.out.println(cons);

        String imagePath = "/home/husseljo/IdeaProjects/demo/Ragdag/src/main/webapp/images/8.jpg";
        File tmpDir = new File(imagePath);
        boolean fileExists = tmpDir.exists();
        System.out.println("file exists"+fileExists);

//        for(Object cons: constList) {
//            System.out.println(cons.toString());
//        }
//
    }
    }

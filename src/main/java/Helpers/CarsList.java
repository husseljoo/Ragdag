package Helpers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarsList {
    ResultSet resultSet;
    public CarsList(ResultSet resultSet) {
       this.resultSet = resultSet;
    }

    public List<Car> execute() {
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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error ooccured while retrieving cars!");
            return null;
        }
       return carsList;
    }
}

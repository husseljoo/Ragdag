package Helpers;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultProducer {
    ResultSet resultSet;
    Object dataStructure;
    public ResultProducer(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public <T> Object buildList(Class<T> c, String[] paramaterNames) {
        Constructor constructor = c.getConstructors()[0];
        Class<?>[] types = constructor.getParameterTypes();
        try {
        int i = 0;
        while(resultSet.next()) {
            for(int j=0;j<paramaterNames.length;j++) {
                List<Object> list = new ArrayList<>();
                Object obj = resultSet.getObject(paramaterNames[i]);
                list.add(obj);
                constructor.newInstance(list);
            }

            Integer id = resultSet.getInt("id");
            String brand = resultSet.getString("brand");
            String model = resultSet.getString("model");
            Integer year = resultSet.getInt("year");
            String color = resultSet.getString("color");
            String country = resultSet.getString("name"); //Country.name not Cars.country
            String countryCode = resultSet.getString("country_code"); //Country.name not Cars.country
            Car car = new Car(id, brand, model, year, color, country, countryCode);
//            carsList.add(car);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
      return null;
    }
}
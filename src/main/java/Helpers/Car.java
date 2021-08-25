package Helpers;

public class Car {
    int id;
    String brand;
    String model;
    int year;
    String color;
    String country;
    String countryCode;

    public Car(int id, String brand, String model, int year, String color, String country, String countryCode) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.country = country;
        this.countryCode = countryCode;
    }
    public String toString() {
        return "Id= " +this.id+ ", Brand= " +this.brand+ ", Model= " +this.model+ ", Year= " +this.year+ ", Color= " +this.color+ ", Country= " +this.country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    }
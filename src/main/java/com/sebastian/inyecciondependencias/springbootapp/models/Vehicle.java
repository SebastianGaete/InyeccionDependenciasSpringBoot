package com.sebastian.inyecciondependencias.springbootapp.models;

public class Vehicle {

    private Integer id;
    private String brand;
    private String model;
    private String color;
    private Integer year;

    public Vehicle() {
    }

    public Vehicle(Integer id, String brand, String model, String color, Integer year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
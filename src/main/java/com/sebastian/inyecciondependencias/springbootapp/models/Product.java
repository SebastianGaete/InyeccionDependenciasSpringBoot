package com.sebastian.inyecciondependencias.springbootapp.models;


public class Product implements Cloneable {
    
    private Integer id;
    private String name;
    private String description;
    private Integer price;

    
    public Product() {
    }
    
    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Integer id, String name, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }


    @Override
    public Object clone()  {
        try{
            return super.clone();

        }catch( CloneNotSupportedException e){
            return new Product(getId(), getName(), getDescription(), getPrice());
        }
    }

    

}
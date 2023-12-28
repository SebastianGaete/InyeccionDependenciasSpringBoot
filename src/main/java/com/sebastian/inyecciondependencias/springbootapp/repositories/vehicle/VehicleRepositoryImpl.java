package com.sebastian.inyecciondependencias.springbootapp.repositories.vehicle;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sebastian.inyecciondependencias.springbootapp.models.Vehicle;
import com.sebastian.inyecciondependencias.springbootapp.repositories.IObjectRepository;


@Repository
public class VehicleRepositoryImpl implements IObjectRepository<Vehicle> {
    
    private List<Vehicle> carList;

    public VehicleRepositoryImpl() {
        this.carList = Arrays.asList(
            new Vehicle(1, "Toyota", "Yaris", "Red", 2002),
            new Vehicle(2, "Chevrolet", "Spark GT", "Blue", 2012),
            new Vehicle(3, "Chevrolet", "Sail", "Green", 2021),
            new Vehicle(4, "Nissan", "March", "Grey", 2023),
            new Vehicle(5, "Hyundai", "Tucson", "White", 2020)
        );
    }

    @Override
    public List<Vehicle> findAll() {
        return carList;
    }

    @Override
    public Vehicle findById(Integer id) {
        return findAll().stream()
        .filter(v -> v.getId().equals(id))
        .findFirst()
        .orElseThrow();
    }

    

    

}
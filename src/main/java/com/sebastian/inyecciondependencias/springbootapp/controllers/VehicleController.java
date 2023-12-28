package com.sebastian.inyecciondependencias.springbootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebastian.inyecciondependencias.springbootapp.models.Vehicle;
import com.sebastian.inyecciondependencias.springbootapp.services.IObjectService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    @Autowired
    private IObjectService<Vehicle> serviceVehicle;


    @GetMapping("/findall")
    public List<Vehicle> findAll(){
        return serviceVehicle.findAll();
    }

    @GetMapping("/findobject/{id}")
    public Vehicle findById(@PathVariable Integer id){
        return serviceVehicle.findById(id);
        
    }
}
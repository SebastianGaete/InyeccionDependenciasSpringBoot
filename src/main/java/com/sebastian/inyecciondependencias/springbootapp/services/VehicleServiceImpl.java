package com.sebastian.inyecciondependencias.springbootapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastian.inyecciondependencias.springbootapp.models.Vehicle;
import com.sebastian.inyecciondependencias.springbootapp.repositories.IObjectRepository;

@Service
public class VehicleServiceImpl implements IObjectService<Vehicle>{

    @Autowired
    private IObjectRepository<Vehicle> repository;

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle findById(Integer id) {
        return repository.findById(id);
    }


}
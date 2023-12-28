package com.sebastian.inyecciondependencias.springbootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebastian.inyecciondependencias.springbootapp.models.Person;
import com.sebastian.inyecciondependencias.springbootapp.services.IObjectService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IObjectService<Person> service;
    
    @GetMapping("/findall")
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping("/find/{id}")
    public Person findById(@PathVariable Integer id){
        return service.findById(id);
    }
}
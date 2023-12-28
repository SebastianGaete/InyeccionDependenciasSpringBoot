package com.sebastian.inyecciondependencias.springbootapp.services.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastian.inyecciondependencias.springbootapp.models.Person;
import com.sebastian.inyecciondependencias.springbootapp.repositories.IObjectRepository;
import com.sebastian.inyecciondependencias.springbootapp.services.IObjectService;

@Service
public class PersonServiceJson implements IObjectService<Person>{


    @Autowired
    private IObjectRepository<Person> repository;

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Person findById(Integer id) {
        return repository.findById(id);
    }
    

    
    
}
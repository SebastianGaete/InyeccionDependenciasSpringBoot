package com.sebastian.inyecciondependencias.springbootapp.repositories.person;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebastian.inyecciondependencias.springbootapp.models.Person;
import com.sebastian.inyecciondependencias.springbootapp.repositories.IObjectRepository;


public class PersonRepositoryJson implements IObjectRepository<Person> {
    
    private List<Person> personList;

    
    public PersonRepositoryJson() {
        Resource resource = new ClassPathResource("json/person.json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            personList = Arrays.asList( objectMapper.readValue(resource.getFile(), Person[].class) );
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public Person findById(Integer id) {
        return findAll().stream()
        .filter(p -> p.getId().equals(id))
        .findFirst()
        .orElseThrow();
    }

    

}
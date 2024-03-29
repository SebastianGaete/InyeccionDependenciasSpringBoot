package com.sebastian.inyecciondependencias.springbootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sebastian.inyecciondependencias.springbootapp.models.Product;
import com.sebastian.inyecciondependencias.springbootapp.services.*;


@RestController
@RequestMapping("/product")
public class ProductController {

    /* Aquí tambien inyectamos la instancia de la clase genérica ProductServiceImpl (Component) por medio de su interfáz genérica, 
     * ahorrando colocar por nuestra cuenta el new() .
    */
    @Autowired
    private IObjectService<Product> serviceProduct;


    @GetMapping("/findall")
    public List<Product> findAll(){
        return serviceProduct.findAll();
    }

    @GetMapping("/findobject/{id}")
    public Product findById(@PathVariable Integer id){
        return serviceProduct.findById(id);
    }

    

    
}
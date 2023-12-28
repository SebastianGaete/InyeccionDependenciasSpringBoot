package com.sebastian.inyecciondependencias.springbootapp.services;

import java.util.List;

public interface IObjectService<T> {
    
    List<T> findAll();
    T findById(Integer id);
}
package com.sebastian.inyecciondependencias.springbootapp.repositories;

import java.util.List;

public interface IObjectRepository<T> {
    List<T> findAll();
    T findById(Integer id);
}
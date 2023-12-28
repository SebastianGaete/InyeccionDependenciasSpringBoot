package com.sebastian.inyecciondependencias.springbootapp.services.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sebastian.inyecciondependencias.springbootapp.models.Vehicle;
import com.sebastian.inyecciondependencias.springbootapp.repositories.IObjectRepository;
import com.sebastian.inyecciondependencias.springbootapp.services.IObjectService;

/* Utilizacion de la anotación @Quilifier
 * 
 * En los casos en que quisieramos "seleccionar" un repository que no sea el @Primary, podemos usar la anotación @Qualifier("")
 * para calificar o usar un repository en concreto. Esta anotación se implementa bajo el @Autowired
 */

@Service
public class VehicleServiceImpl implements IObjectService<Vehicle>{

    @Autowired
    @Qualifier("vehicleRepositoryImpl")
    private IObjectRepository<Vehicle> repository;

    /* En este caso tenemos en la app por defecto el repository llamado VehicleRepositoryJpa con la anotación @Primary
     * pero en el service estamos llamando al otro repository mediante la anotación @Quilifier, por lo que la app usará 
     * la data que hay en esa clase repository.
     */

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle findById(Integer id) {
        return repository.findById(id);
    }


}
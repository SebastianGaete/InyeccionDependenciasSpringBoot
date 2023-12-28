package com.sebastian.inyecciondependencias.springbootapp.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.sebastian.inyecciondependencias.springbootapp.models.Vehicle;

/* Utilización de anotación @Primary

 * En los casos en que tengamos dos clases concretas diferentes como repository, pero que implementen la misma interfaz, 
 * el controller no sabrá cual data usar y lanzará un error al compilar, por lo que es necesario marcar alguna de estas clases 
 * concretas como default usando la anotación @Primary, para que la que esté anotada se utilice por defecto.
 
 * Uso del @RequestScope y @SessionScope
 
 * Los Scope son los alcances en los que se pueden modificar la data, en el caso del @RequestScope este permite que el alcance
 * sea único por request y el @SessionScope quiere decir que la modificación de la data seguirá hasta que se termine la sesión
 * (cierre pestaña o navegador)
 */

//@RequestScope
//@SessionScope
@Primary
@Repository
public class VehicleRepositoryJpa implements IObjectRepository<Vehicle>{

    private List<Vehicle> list;

    public VehicleRepositoryJpa() {
        this.list = Arrays.asList(
            new Vehicle(1, "Ferrari", "Huracán", "Black", 2024 )
        );
    }

    @Override
    public List<Vehicle> findAll() {
        return list;
    }

    @Override
    public Vehicle findById(Integer id) {
        return findAll().stream().filter( v -> id.equals(id)).findFirst().orElseThrow();
    }
    
    
}
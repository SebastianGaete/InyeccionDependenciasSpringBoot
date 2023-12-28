package com.sebastian.inyecciondependencias.springbootapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.sebastian.inyecciondependencias.springbootapp.models.Person;
import com.sebastian.inyecciondependencias.springbootapp.repositories.IObjectRepository;
import com.sebastian.inyecciondependencias.springbootapp.repositories.person.PersonRepositoryJson;

/* La utilidad de esta clase es que en esta podemos colocar o añadir @PropertieSource o leer y poblar archivos json
 * para desacoplarlo de la clase principal de SpringBootAppAplication
 */

@Configuration
@PropertySource("classpath:config.properties")
public class ConfigAplication {
    
    /* Con este @Bean podemos poblar nuestra clase Person con la data del archivo person.json */
    @Bean
    @Primary
    IObjectRepository<Person> personRepositoryJson(){
        return new PersonRepositoryJson();
    }
}
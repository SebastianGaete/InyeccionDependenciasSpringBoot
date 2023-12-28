package com.sebastian.inyecciondependencias.springbootapp.repositories.product;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.sebastian.inyecciondependencias.springbootapp.models.Product;
import com.sebastian.inyecciondependencias.springbootapp.repositories.IObjectRepository;

/* La importancia de tener un package "repositories" es que en ella podemos crear clases que contengan DATA 
 * y como así tambien métodos para poder utilizarla.
 */

 /* Cuando se anota una clase con @Component es lo mismo a como que se anotara con @Bean, @Service o @Repository, es exactamente lo mismo,
  * al estar anotado de esta forma automáticamente el framework incorpora esta clase Component y lo añade al contenedor general, generando
  * por debajo un singleton, por lo que genera solo una instancia de la clase, y esta instancia la podemos inyectar en atributos de
  * clases que deseemos utilizarlas, mediante la anotación @Autowired.

  En este caso, como esta es una clase Service, lo anotaremos con la anotación @Repository, que en el fondo será un @Component de 
  todos modos.
  */

@Repository
public class ProductRepositoryImpl implements IObjectRepository<Product>{
    
    private List<Product> products;

    public ProductRepositoryImpl() {
        this.products = Arrays.asList(
            new Product(1, "Notebook", "Notebook gamer", 1500),
            new Product(2, "glass", "glass gamer", 1023),
            new Product(3, "clock", "clock CASIO vintage", 120000),
            new Product(4, "short", "short S red color", 5000)
        );
    }

    @Override
    public List<Product> findAll(){
        return products;
    }

    @Override
    public Product findById(Integer id){
        Product product = findAll().stream()
        .filter(c-> c.getId().equals(id) )
        .findFirst()
        .orElseThrow();
        return product;
    }


}
package com.sebastian.inyecciondependencias.springbootapp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sebastian.inyecciondependencias.springbootapp.models.Product;

/* Dentro de la carpeta "SERVICES" podemos crear clases que van a MANIPULAR u OBTENER la DATA de las clases que se encuentren
 * en la carpeta "RESPOSITORIES". Tambien puede tener mismos métodos, pero usando de por medio los de la clase repository.
 * 
 * Otra de las funciones de la capa Service, es que aquií se puede modificar la data a nuestro gusto, o lo que queramos hacer
 * según nuestra lógica de negocio.
*/

/* Cuando se anota una clase con @Component es lo mismo a como que se anotara con @Bean, @Service o @Repository, es exactamente lo mismo,
  * al estar anotado de esta forma automáticamente el framework incorpora esta clase Componet y lo añade al contenedor general generando
  * por debajo un singleton, por lo que genera solo una instancia de la clase, y esta instancia la podemos inyectar en atributos de
  * clases que deseemos utilizarlas, mediante la anotación @Autowired.

  En este caso, como esta es una clase Service, lo anotaremos con la anotación @Service, que en el fondo será un @Component de todos modos
*/

@Service
public class ProductServiceImpl implements IObjectService<Product> {

    /* Con este atributo accedemos a los métodos que contienen la data de nuestro ProductRepositoryImpl, pero utilizamos
     * la inyeccion de dependencias de la clase @Component o @Repository ProducRepositoryImpl mediante la anotación @Autowired.
     * Ahorrando el colocar por nuestra cuenta el new()
     */
    @Autowired
    private IObjectService<Product> repository;


    /* Como se mencionó anteriormente, podemos modificar a nuestro gusto como queremos devolver los datos que se encuentran
     * en el repository. en este caso modificamos el precio y el nombre con la función map() de Java 8. 
     * Si bien, al utilizar la función map() estamos creando una nueva instacia del producto y por cada request el precio va
     * a aumentar aún más en nuestro controller, entonces para solucionar eso, podemos crear una instancia de Producto en donde
     * vamos a pasar los valores del p de map para que se muestre esa.
     */
    @Override
    public List<Product> findAll(){

        return repository.findAll().stream()
        .map( p -> {
            Double newPrice = p.getPrice() * 3.2d; // Suma de impuesto

            // Product newProduct = new Product(p.getId(), p.getName(), p.getDescription(), newPrice.intValue());

            /* Uso del método clone de la interfaz Cloneable, hace lo mismo que el ejemplo comentado de arriba. */
            Product newProduct = (Product)p.clone();
            newProduct.setPrice(newPrice.intValue());
            return newProduct;
        })
        .map( p -> {
            p.setName( p.getName().toUpperCase());
            return p;
        })
        .toList();
    }

    @Override
    public Product findById(Integer id){
        return repository.findById(id);
    }

}
package org.bedu.netflix.repository;

import java.util.Optional;

import org.bedu.netflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** 
 * Un Repositorio es un objeto que permite acceder o manipular datos
 * de una base de datos a través de métodos.
 * 
 * JpaRepository provee de las operaciones básicas del CRUD.
 *  - Obtener todo (findAll)
 *  - Obtener por ID (findById)
 *  - Guardar/actualizar (save)
 *  - Eliminar (deleteById)
 * 
 * Y recibe 2 parámetros:
 *  - El tipo de la entidad
 *  - El tipo de la llave o ID
 * 
 * 
 * Los tipos de datos con letras minúsculas son tipos de datos PRIMITIVOS (nacen con el lenguaje)
 * - int
 * - boolean
 * - long
 * - char
 * 
 * Existe su versión de objetos (Wrapper Classes)
 * - int -> Integer
 * - long -> Long
 * - boolean -> Boolean
 */ 
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    Optional<Movie> findByTitle(String title);
}

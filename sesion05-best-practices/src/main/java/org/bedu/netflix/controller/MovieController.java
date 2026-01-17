package org.bedu.netflix.controller;

import java.util.List;

import org.bedu.netflix.model.Movie;
import org.bedu.netflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Los controladores sólo deben encargarse de obtener/leer
    la información y "regresar" la información a través del protocolo HTTP.

    IoC (Inversion of Control): Es un mecanismo de Spring para crear
    automáticamente las instancias/objetos de sus componentes.

    ------------------------------------------------------------------

    API => Es un software para comunicar otro software 

    API REST => Son APIs aplicando las buenas prácticas

    1. No hay existe un estado, es decir, la petición contiene toda
    la información necesaria para funcionar.

    2. Transmitir XML o JSON (ya nadie usa XML)

    3. Al nombrar endpoints no usar verbos, voy a utilizar los sustantivos (en plural)
    
    4. Utilizar los verbos/métodos de HTTP correctamente:

        a. GET - Leer información
        b. POST - Crear información
        c. PUT - Actualizar información de manera parcial
        d. DELETE - Eliminar información

        Nota: PATCH técnicamente se usa para actualizar la información de maner parcial 
        y PUT originalmente era para reemplazar toda información.

        Lo que hizo fue dejar de usar PATCH y usar PUT como si fuera PATCH.

        GET /movies -> Obtener las películas
        POST /movies -> Crear una nueva película

        Nota: @RequestMapping por defecto es "GET"
    
    5. Reflejar la jerarquia de los datos en las urls

        GET /escuelas -> Obtener las escuelas
        GET /alumnos -> Obtener los alumnos

        GET /escuelas/100/alumnos -> Obtener los alumnos de la escuela 100

        GET /escuelas/100/alumnos/20/calificaciones -> De la escuela 100, del alumno 20, obtener sus calificaciones
    */
@RestController
public class MovieController {

    @Autowired // -> Injecta una instancia de un componente
    private MovieService service;
 
    // Obtener todos las peliculas
    @GetMapping("movies")
    public List<Movie> getMovies() {
        return service.getMovies();
    }

    // Obtener una película por ID
    @GetMapping("movies/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    // Crear una película
    @PostMapping("movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return service.createMovie(movie);
    }
}

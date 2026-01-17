package org.bedu.netflix.controller;

import java.util.List;

import org.bedu.netflix.model.Movie;
import org.bedu.netflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Los controladores sólo deben encargarse de obtener/leer
    la información y "regresar" la información a través del protocolo HTTP.

    IoC (Inversion of Control): Es un mecanismo de Spring para crear
    automáticamente las instancias/objetos de sus componentes.
 */
@RestController
public class MovieController {

    @Autowired
    private MovieService service;
 
    // Obtener todos las peliculas
    @RequestMapping("getMovies")
    public List<Movie> getMovies() {
        return service.getMovies();
    }

    // Obtener una película

    // Crear una película
    @RequestMapping("createMovie")
    public Movie createMovie(@RequestBody Movie movie) {
        return service.createMovie(movie);
    }
}

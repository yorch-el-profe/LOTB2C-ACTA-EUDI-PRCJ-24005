package org.bedu.netflix.controller;

import java.util.List;
import java.util.Optional;

import org.bedu.netflix.entity.Movie;
import org.bedu.netflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies") // Le agrega el prefijo /movies a todos los endpoints
public class MovieController {

    @Autowired
    private MovieService service;
 
    @GetMapping
    public List<Movie> getMovies() {
        return service.getMovies();
    }

    @GetMapping("{id}")
    public Optional<Movie> getMovieById(@PathVariable long id) {
        return service.getMovieById(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return service.createMovie(movie);
    }

    @PutMapping("{id}")
    public void updateMovie(@PathVariable long id, @RequestBody Movie movie) {
        service.updateMovie(id, movie);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable long id) {
        service.deleteMovie(id);
    }
}

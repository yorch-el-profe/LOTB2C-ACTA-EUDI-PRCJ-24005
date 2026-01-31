package org.bedu.netflix.service;

import java.util.List;
import java.util.Optional;

import org.bedu.netflix.entity.Movie;
import org.bedu.netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Optional<Movie> getMovieById(long id) {
        return repository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return repository.save(movie);
    }

    public void deleteMovie(long id) {
        repository.deleteById(id);
    }

    public void updateMovie(long id, Movie movie) {
        // 1. Busco en BD el objeto a actualizar
        Optional<Movie> dbMovie = repository.findById(id);

        // 2. Verificamos que el objeto no sea nulo
        // isEmpty() -> true si está vacío o nulo
        // isPresent() -> true si tiene un objeto
        if (dbMovie.isPresent()) {

            // 3. Sacar el objeto de su caja
            Movie updatedMovie = dbMovie.get();

            if (movie.getTitle() != null) {
                // Sustituyendo el valor viejo por el nuevo
                updatedMovie.setTitle(movie.getTitle());
            }

            // 4. Actualizar en la BD
            repository.save(updatedMovie);
        }
    }
}

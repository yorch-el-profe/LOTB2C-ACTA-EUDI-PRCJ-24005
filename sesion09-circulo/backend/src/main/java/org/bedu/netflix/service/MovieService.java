package org.bedu.netflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bedu.netflix.dto.CreateActorDTO;
import org.bedu.netflix.dto.CreateDirectorDTO;
import org.bedu.netflix.dto.CreateMovieDTO;
import org.bedu.netflix.dto.MovieDTO;
import org.bedu.netflix.dto.UpdateMovieDTO;
import org.bedu.netflix.entity.Actor;
import org.bedu.netflix.entity.Director;
import org.bedu.netflix.entity.Movie;
import org.bedu.netflix.mapper.ActorMapper;
import org.bedu.netflix.mapper.DirectorMapper;
import org.bedu.netflix.mapper.MovieMapper;
import org.bedu.netflix.repository.ActorRepository;
import org.bedu.netflix.repository.DirectorRepository;
import org.bedu.netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieMapper mapper;

    @Autowired
    private DirectorMapper directorMapper;

    @Autowired
    private ActorMapper actorMapper;

    public List<MovieDTO> getMovies() {
        List<Movie> movies = repository.findAll();
        List<MovieDTO> dtos = new ArrayList<>();
        for (Movie movie : movies) {
            dtos.add(mapper.toDTO(movie));
        }
        return dtos;
    }

    public Optional<MovieDTO> getMovieById(long id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    public MovieDTO createMovie(CreateMovieDTO movie) {
        // Buscar o crear director
        Director director = directorRepository.findByName(movie.getDirector().getName())
                .orElseGet(() -> directorRepository.save(directorMapper.toModel(movie.getDirector())));

        // Buscar o crear actores
        List<Actor> actors = new ArrayList<>();
        for (CreateActorDTO actorDto : movie.getActors()) {
            Actor actor = actorRepository.findByName(actorDto.getName())
                    .orElseGet(() -> actorRepository.save(actorMapper.toModel(actorDto)));
            actors.add(actor);
        }

        Movie entity = mapper.toModel(movie);
        entity.setDirector(director);
        entity.setActors(actors);

        return mapper.toDTO(repository.save(entity));
    }

    public void deleteMovie(long id) {
        repository.deleteById(id);
    }

    public void updateMovie(long id, UpdateMovieDTO movie) {
        // 1. Busco en BD el objeto a actualizar
        Optional<Movie> dbMovie = repository.findById(id);

        // 2. Verificamos que el objeto no sea nulo
        // isEmpty() -> true si está vacío o nulo
        // isPresent() -> true si tiene un objeto
        if (dbMovie.isPresent()) {

            // 3. Sacar el objeto de su caja
            Movie updatedMovie = dbMovie.get();

            mapper.updateModel(updatedMovie, movie);

            // 4. Actualizar en la BD
            repository.save(updatedMovie);
        }
    }
}

package org.bedu.netflix.mapper;

import org.bedu.netflix.dto.CreateMovieDTO;
import org.bedu.netflix.dto.MovieDTO;
import org.bedu.netflix.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    
    // Service -> Repository
    public Movie toModel(CreateMovieDTO dto) {
        Movie entity = new Movie();

        entity.setTitle(dto.getTitle());
        entity.setYear(dto.getYear());
        entity.setGenre(dto.getGenre());

        return entity;
    }

    // Repository -> Service
    public MovieDTO toDTO(Movie entity) {
        MovieDTO dto = new MovieDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setGenre(entity.getGenre());
        dto.setYear(entity.getYear());

        return dto;
    }
}

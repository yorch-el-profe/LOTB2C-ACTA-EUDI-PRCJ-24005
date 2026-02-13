package org.bedu.netflix.mapper;

import org.bedu.netflix.dto.CreateMovieDTO;
import org.bedu.netflix.dto.MovieDTO;
import org.bedu.netflix.dto.UpdateMovieDTO;
import org.bedu.netflix.entity.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    
    // Service -> Repository
    public Movie toModel(CreateMovieDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Movie entity = new Movie();

        entity.setTitle(dto.getTitle());
        entity.setYear(dto.getYear());
        entity.setGenre(dto.getGenre());
        entity.setPoster(dto.getPoster());

        return entity;
    }

    // For update
    public void updateModel(Movie entity, UpdateMovieDTO dto) {
        if (dto == null) {
            return;
        }
        
        if (dto.getTitle() != null) {
            entity.setTitle(dto.getTitle());
        }
        if (dto.getYear() != null) {
            entity.setYear(dto.getYear());
        }
        if (dto.getGenre() != null) {
            entity.setGenre(dto.getGenre());
        }
        if (dto.getPoster() != null) {
            entity.setPoster(dto.getPoster());
        }
    }

    // Repository -> Service
    public MovieDTO toDTO(Movie entity) {
        MovieDTO dto = new MovieDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setGenre(entity.getGenre());
        dto.setYear(entity.getYear());
        dto.setPoster(entity.getPoster());

        return dto;
    }
}

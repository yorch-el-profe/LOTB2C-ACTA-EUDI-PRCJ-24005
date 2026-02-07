package org.bedu.netflix.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.bedu.netflix.dto.CreateMovieDTO;
import org.bedu.netflix.entity.Movie;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // Invoca el IoC de Spring
public class MovieMapperTest {
    
    @Autowired
    private MovieMapper mapper;

    @Test
    @DisplayName("El mapper se está inyectando a través de Spring")
    public void smoke() {
        assertNotNull(mapper);
    }

    @Test
    @DisplayName("Si el DTO es nulo entonces el modelo es nulo")
    public void isNull() {
        Movie model = mapper.toModel(null);

        // Verifica que el valor sea nulo
        assertNull(model);
    }

    @Test
    @DisplayName("Convierte de DTO a Model")
    public void toModel() {
        // Arrange
        CreateMovieDTO dto = new CreateMovieDTO();

        dto.setTitle("Kpop Demon Hunters");
        dto.setGenre("Animation");
        dto.setYear(2025);

        // Act
        Movie movie = mapper.toModel(dto);

        // Assert
        assertNotNull(movie); // La pelicula no deberia ser nula

        // Todas las propiedades deben de coincidir
        assertEquals(dto.getTitle(), movie.getTitle());
        assertEquals(dto.getGenre(), movie.getGenre());
        assertEquals(dto.getYear(), movie.getYear());
    }
    
}

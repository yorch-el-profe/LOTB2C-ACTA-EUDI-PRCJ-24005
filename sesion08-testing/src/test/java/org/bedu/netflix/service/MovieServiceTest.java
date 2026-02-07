package org.bedu.netflix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.bedu.netflix.dto.MovieDTO;
import org.bedu.netflix.entity.Movie;
import org.bedu.netflix.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

/**
 * SpringBootTest es una combinación del IoC (administració de instancias)
 * y Mockito (nos ayuda a simular/falsificar métodos u objetos).
 */
@SpringBootTest
public class MovieServiceTest {

    // Sustituye en el IoC el objeto y pone nuestra implementación
    // En este caso NO se van a realizar consultas a BD
    @MockitoBean
    private MovieRepository repository;
    
    @Autowired
    private MovieService service;

    @Test
    @DisplayName("Si el repositorio esta vacío, el servicio regresa vacío")
    public void empty() {
        // Arrange
        // La precondición es que el repositorio esté vacío al invocar "findAll"
        // Cuando se invoque ".findAll()" regresa []
        when(repository.findAll()).thenReturn(new LinkedList<>());

        // Act
        List<Movie> movies = service.getMovies();

        // Assert
        assertEquals(0, movies.size());
    }
}

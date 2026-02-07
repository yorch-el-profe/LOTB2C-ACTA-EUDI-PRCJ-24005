package org.bedu.netflix.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;

import org.bedu.netflix.service.MovieService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

// WebMvcTest me ayuda a realizar "peticiones" en un contexto de HTTP
// para pruebas unitarias

@WebMvcTest(MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc; // simular las peticiones HTTP

    @MockitoBean
    private MovieService service;
    
    @Test
    @DisplayName("Si el servicio regresa vacío entonces el controlador regresa vacío")
    public void empty() throws Exception {
        // Arrange
        when(service.getMovies()).thenReturn(new LinkedList<>());

        // perform simula una petición de HTTP

        // Act
        // Como en POSTMAN o BRUNO, tengo que describir mi petición de HTTP
        mockMvc.perform(get("/movies"))
            // Assert
            // Empiezo a realizar los asserts pero a nivel de HTTP
            // 1. El status sea OK (200)
            .andExpect(status().isOk())
            // 2. El contenido en forma de texo sea "[]"
            // si fuera un objeto, sería algo como [{ "title": "Harry Potter" }]
            .andExpect(content().string("[]"));
    }
}

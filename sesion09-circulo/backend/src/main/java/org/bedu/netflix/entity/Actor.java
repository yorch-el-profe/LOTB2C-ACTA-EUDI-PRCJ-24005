package org.bedu.netflix.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Tenemos que analizar de qué manera interactuan las entidades:
 * 
 * Uno a uno (One to One)
 * 
 *      Vehiculos - Matriculas (1 - 1)
 * 
 *      La relación es uno a uno porque un vehículo tiene una única matricula
 *      y viceversa.
 * 
 * Uno a muchos / Muchos a uno (One To Many / Many To One)
 * 
 *      Usuarios/Cuenta - Canales (1 - N)
 * 
 *      La relación es uno a muchos porque un usuario puede tener varios canales
 *      de Youtube pero un canal solo le pertenece a un usuario.
 * 
 *      Usuarios - Tweets (1 - N)
 * 
 *      La relación es uno a muchos porque un usuario puede escribir varios tweets
 *      pero un tweet solo es escrito por un único usuario.
 * 
 * Muchos a muchos (Many to Many)
 * 
 *      Una relación es muchos a muchos cuando es uno a muchos y muchos a uno al
 *      mismo tiempo.
 * 
 *      Clientes - Productos (N - M)
 * 
 *      La relación es muchos a muchos porque:
 * 
 *          1. Un cliente puede comprar varios productos
 *          2. Un producto puede ser comprado por varios clientes
 * 
 * 
 *  ---------------------------------------------------------------------
 * 
 *      Movie - Actor 
 * 
 *      La relación es "muchos a muchos" porque:
 * 
 *          1. En una pelicula actuan varios actores
 *          2. Un actor puede participar en varias peliculas
 */

@Entity
@Table(name = "actors")
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "actors") // La relación principal esta definida en "Movie" (OPCIONAL)
    private List<Movie> movies;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

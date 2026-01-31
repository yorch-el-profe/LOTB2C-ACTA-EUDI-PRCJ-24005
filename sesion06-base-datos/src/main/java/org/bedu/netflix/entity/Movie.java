package org.bedu.netflix.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity -> Indica que esta clase es una tabla de base de datos
// @Table -> Cambia únicmanete el nombre de la tabla en la base de datos
// @GeneratedValue -> Indica que el valor del ID se genera automáticamente

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos -> Columnas de la tabla

    // En base de datos NULL = vacío
    // nullable = false -> Hace obligatoria una columna
    @Column(nullable = false)
    private String title;

    // columnDefinition -> Permite alterar la definición de la columna con SQL
    @Column(columnDefinition = "INT CHECK(year >= 1888)")
    private int year;

    // Por defecto puede ser nulo (opcional)
    private String genre;

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

}
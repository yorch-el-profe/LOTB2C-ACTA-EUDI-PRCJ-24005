package org.bedu.netflix.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private int year;

    private String genre;

    // Uno a Muchos 
    @ManyToOne // (OBLIGATORIO)
    @JoinColumn(name = "id_director")
    private Director director;

    // Muchos a muchos
    @ManyToMany // (OBLIGATORIO pero el programador decide donde ponerlo)
    @JoinTable(
        name = "movie_actors", // Creamos una tabla intermedia
        joinColumns = @JoinColumn(name = "id_movie"), // El id de Movie se va a llamar así en la nueva tabla
        inverseJoinColumns = @JoinColumn(name = "id_actor") // El id de Actor se va a llamar así en la nueva tabla
    )
    private List<Actor> actors;

    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    public List<Actor> getActors() {
        return actors;
    }
    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
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
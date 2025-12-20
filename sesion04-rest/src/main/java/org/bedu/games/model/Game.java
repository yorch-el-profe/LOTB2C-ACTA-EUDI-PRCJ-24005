package org.bedu.games.model;

/**
 * POJO (Plain Old Java Object)
 * 
 * Una clase que no utiliza herencia especial, ni implementa interfaces.
 * En resumen, no tiene métodos, mas que los de get y set.
 */
public class Game {
   
    private Integer id;
    private String title;
    private Integer year;
    private String genre;

    public Game(Integer id, String title, Integer year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "[Titulo: " + title + ", Año: " + year + ", Genero: " + genre + "]";
    }
}

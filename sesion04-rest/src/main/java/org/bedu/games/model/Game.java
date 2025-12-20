package org.bedu.games.model;

/**
 * POJO (Plain Old Java Object)
 * 
 * Una clase que no utiliza herencia especial, ni implementa interfaces.
 * En resumen, no tiene métodos, mas que los de get y set.
 */
public class Game {
   
    private int id;
    private String title;
    private int year;
    private String genre;

    public Game(int id, String title, int year, String genre) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

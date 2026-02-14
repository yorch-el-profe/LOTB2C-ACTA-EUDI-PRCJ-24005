package org.bedu.netflix.dto;

import java.util.List;

public class MovieDetailsDTO {
    
    private long id;
    private String title;
    private int year;
    private String genre;
    private String poster;
    private DirectorDTO director;
    private List<ActorDTO> actors;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public DirectorDTO getDirector() {
        return director;
    }
    public void setDirector(DirectorDTO director) {
        this.director = director;
    }
    public List<ActorDTO> getActors() {
        return actors;
    }
    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }
}
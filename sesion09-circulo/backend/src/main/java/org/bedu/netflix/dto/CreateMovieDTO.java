package org.bedu.netflix.dto;

import java.util.List;

public class CreateMovieDTO {
    
    private String title;
    private int year;
    private String genre;
    private String poster;
    private CreateDirectorDTO director;
    private List<CreateActorDTO> actors;
    
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
    public CreateDirectorDTO getDirector() {
        return director;
    }
    public void setDirector(CreateDirectorDTO director) {
        this.director = director;
    }
    public List<CreateActorDTO> getActors() {
        return actors;
    }
    public void setActors(List<CreateActorDTO> actors) {
        this.actors = actors;
    }
}

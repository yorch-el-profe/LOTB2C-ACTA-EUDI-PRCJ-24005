package org.bedu.netflix;

import java.util.ArrayList;
import java.util.List;

import org.bedu.netflix.entity.Actor;
import org.bedu.netflix.entity.Director;
import org.bedu.netflix.entity.Movie;
import org.bedu.netflix.repository.ActorRepository;
import org.bedu.netflix.repository.DirectorRepository;
import org.bedu.netflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * El objetivo es precargar datos en la base de datos al iniciar el código
*/

@Component
public class DBSeeder implements ApplicationRunner {
    
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) {

        // Lista de películas famosas con sus datos
        List<MovieData> moviesData = new ArrayList<>();
        moviesData.add(new MovieData("The Shawshank Redemption", 1994, "Drama", "Frank Darabont", 
            "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg",
            new String[]{"Tim Robbins", "Morgan Freeman"}));
        moviesData.add(new MovieData("The Godfather", 1972, "Crime", "Francis Ford Coppola", 
            "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
            new String[]{"Marlon Brando", "Al Pacino"}));
        moviesData.add(new MovieData("The Dark Knight", 2008, "Action", "Christopher Nolan", 
            "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg",
            new String[]{"Christian Bale", "Heath Ledger"}));
        moviesData.add(new MovieData("Pulp Fiction", 1994, "Crime", "Quentin Tarantino", 
            "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
            new String[]{"John Travolta", "Uma Thurman"}));
        moviesData.add(new MovieData("Inception", 2010, "Sci-Fi", "Christopher Nolan", 
            "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg",
            new String[]{"Leonardo DiCaprio", "Marion Cotillard"}));
        moviesData.add(new MovieData("Fight Club", 1999, "Drama", "David Fincher", 
            "https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
            new String[]{"Brad Pitt", "Edward Norton"}));
        moviesData.add(new MovieData("Forrest Gump", 1994, "Drama", "Robert Zemeckis", 
            "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg",
            new String[]{"Tom Hanks", "Robin Wright"}));
        moviesData.add(new MovieData("The Matrix", 1999, "Sci-Fi", "The Wachowskis", 
            "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg",
            new String[]{"Keanu Reeves", "Laurence Fishburne"}));
        moviesData.add(new MovieData("Goodfellas", 1990, "Crime", "Martin Scorsese", 
            "https://m.media-amazon.com/images/M/MV5BY2NkZjEzMDgtN2RjYy00YzM1LWI4ZmQtMjIwYjFjNmI3ZGEwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
            new String[]{"Robert De Niro", "Ray Liotta"}));
        moviesData.add(new MovieData("The Lord of the Rings: The Fellowship of the Ring", 2001, "Fantasy", "Peter Jackson", 
            "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_.jpg",
            new String[]{"Elijah Wood", "Ian McKellen"}));

        for (MovieData data : moviesData) {
            if (!movieRepository.findByTitle(data.title).isPresent()) {
                // Buscar o crear director
                Director director = directorRepository.findByName(data.directorName)
                    .orElseGet(() -> {
                        Director d = new Director();
                        d.setName(data.directorName);
                        return directorRepository.save(d);
                    });

                // Buscar o crear actores
                List<Actor> actors = new ArrayList<>();
                for (String actorName : data.actorNames) {
                    Actor actor = actorRepository.findByName(actorName)
                        .orElseGet(() -> {
                            Actor a = new Actor();
                            a.setName(actorName);
                            return actorRepository.save(a);
                        });
                    actors.add(actor);
                }

                // Crear película
                Movie movie = new Movie();
                movie.setTitle(data.title);
                movie.setYear(data.year);
                movie.setGenre(data.genre);
                movie.setPoster(data.poster);
                movie.setDirector(director);
                movie.setActors(actors);

                movieRepository.save(movie);
            }
        }
    }

    private static class MovieData {
        String title;
        int year;
        String genre;
        String directorName;
        String poster;
        String[] actorNames;

        MovieData(String title, int year, String genre, String directorName, String poster, String[] actorNames) {
            this.title = title;
            this.year = year;
            this.genre = genre;
            this.directorName = directorName;
            this.poster = poster;
            this.actorNames = actorNames;
        }
    }
}

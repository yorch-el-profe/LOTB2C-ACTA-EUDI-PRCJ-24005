// api.js - Funciones que simulan llamadas al backend

let movies = [
  { id: 1, title: "Inception", year: 2010, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg" },
  { id: 2, title: "The Dark Knight", year: 2008, genre: "Action", poster: "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg" },
  { id: 3, title: "Pulp Fiction", year: 1994, genre: "Crime", poster: "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg" },
  { id: 4, title: "The Shawshank Redemption", year: 1994, genre: "Drama", poster: "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg" },
  { id: 5, title: "Forrest Gump", year: 1994, genre: "Drama", poster: "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg" },
  { id: 6, title: "The Matrix", year: 1999, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg" },
  { id: 7, title: "Interstellar", year: 2014, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg" },
  { id: 8, title: "Fight Club", year: 1999, genre: "Drama", poster: "https://m.media-amazon.com/images/M/MV5BNDIzNDU0YzEtYzE5Ni00ZjlkLTk5ZjgtNjM3NWE4YzA3Nzk3XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_.jpg" },
  { id: 9, title: "The Godfather", year: 1972, genre: "Crime", poster: "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg" },
  { id: 10, title: "Avatar", year: 2009, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzAxXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_.jpg" },
]

let fullMovies = {
  1: { id: 1, title: "Inception", year: 2010, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_.jpg", director: { id: 1, name: "Christopher Nolan" }, actors: [{ id: 1, name: "Leonardo DiCaprio" }, { id: 2, name: "Marion Cotillard" }] },
  2: { id: 2, title: "The Dark Knight", year: 2008, genre: "Action", poster: "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_.jpg", director: { id: 1, name: "Christopher Nolan" }, actors: [{ id: 3, name: "Christian Bale" }, { id: 4, name: "Heath Ledger" }] },
  3: { id: 3, title: "Pulp Fiction", year: 1994, genre: "Crime", poster: "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", director: { id: 2, name: "Quentin Tarantino" }, actors: [{ id: 5, name: "John Travolta" }, { id: 6, name: "Samuel L. Jackson" }] },
  4: { id: 4, title: "The Shawshank Redemption", year: 1994, genre: "Drama", poster: "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg", director: { id: 3, name: "Frank Darabont" }, actors: [{ id: 7, name: "Tim Robbins" }, { id: 8, name: "Morgan Freeman" }] },
  5: { id: 5, title: "Forrest Gump", year: 1994, genre: "Drama", poster: "https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_.jpg", director: { id: 4, name: "Robert Zemeckis" }, actors: [{ id: 9, name: "Tom Hanks" }, { id: 10, name: "Robin Wright" }] },
  6: { id: 6, title: "The Matrix", year: 1999, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg", director: { id: 5, name: "Lana Wachowski" }, actors: [{ id: 11, name: "Keanu Reeves" }, { id: 12, name: "Laurence Fishburne" }] },
  7: { id: 7, title: "Interstellar", year: 2014, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg", director: { id: 1, name: "Christopher Nolan" }, actors: [{ id: 13, name: "Matthew McConaughey" }, { id: 14, name: "Anne Hathaway" }] },
  8: { id: 8, title: "Fight Club", year: 1999, genre: "Drama", poster: "https://m.media-amazon.com/images/M/MV5BNDIzNDU0YzEtYzE5Ni00ZjlkLTk5ZjgtNjM3NWE4YzA3Nzk3XkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_.jpg", director: { id: 6, name: "David Fincher" }, actors: [{ id: 15, name: "Brad Pitt" }, { id: 16, name: "Edward Norton" }] },
  9: { id: 9, title: "The Godfather", year: 1972, genre: "Crime", poster: "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg", director: { id: 7, name: "Francis Ford Coppola" }, actors: [{ id: 17, name: "Marlon Brando" }, { id: 18, name: "Al Pacino" }] },
  10: { id: 10, title: "Avatar", year: 2009, genre: "Sci-Fi", poster: "https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzAxXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_.jpg", director: { id: 8, name: "James Cameron" }, actors: [{ id: 19, name: "Sam Worthington" }, { id: 20, name: "Zoe Saldana" }] },
}

let directors = [
  { id: 1, name: "Christopher Nolan" },
  { id: 2, name: "Quentin Tarantino" },
  { id: 3, name: "Frank Darabont" },
  { id: 4, name: "Robert Zemeckis" },
  { id: 5, name: "Lana Wachowski" },
  { id: 6, name: "David Fincher" },
  { id: 7, name: "Francis Ford Coppola" },
  { id: 8, name: "James Cameron" },
]

let actors = [
  { id: 1, name: "Leonardo DiCaprio" },
  { id: 2, name: "Marion Cotillard" },
  { id: 3, name: "Christian Bale" },
  { id: 4, name: "Heath Ledger" },
  { id: 5, name: "John Travolta" },
  { id: 6, name: "Samuel L. Jackson" },
  { id: 7, name: "Tim Robbins" },
  { id: 8, name: "Morgan Freeman" },
  { id: 9, name: "Tom Hanks" },
  { id: 10, name: "Robin Wright" },
  { id: 11, name: "Keanu Reeves" },
  { id: 12, name: "Laurence Fishburne" },
  { id: 13, name: "Matthew McConaughey" },
  { id: 14, name: "Anne Hathaway" },
  { id: 15, name: "Brad Pitt" },
  { id: 16, name: "Edward Norton" },
  { id: 17, name: "Marlon Brando" },
  { id: 18, name: "Al Pacino" },
  { id: 19, name: "Sam Worthington" },
  { id: 20, name: "Zoe Saldana" },
]

// Funciones simuladas asíncronas
export const getMovies = async () => {
  await new Promise(resolve => setTimeout(resolve, 300)); // Simular delay
  return movies;
}

export const getMovie = async (id) => {
  await new Promise(resolve => setTimeout(resolve, 300));
  return fullMovies[id];
}

export const postMovie = async (movie) => {
  await new Promise(resolve => setTimeout(resolve, 300));
  // Handle new director
  if (movie.director && !movie.director.id) {
    const newDirId = Math.max(...directors.map(d => d.id)) + 1;
    const newDir = { ...movie.director, id: newDirId };
    directors.push(newDir);
    movie.director = newDir;
  }
  // Handle new actors
  movie.actors = movie.actors.map(actor => {
    if (!actor.id) {
      const newActId = Math.max(...actors.map(a => a.id)) + 1;
      const newAct = { ...actor, id: newActId };
      actors.push(newAct);
      return newAct;
    }
    return actor;
  });
  const newId = Math.max(...movies.map(m => m.id)) + 1;
  const newMovie = { ...movie, id: newId };
  movies.push(newMovie);
  fullMovies[newId] = newMovie;
  return newMovie;
}

export const postDirector = async (director) => {
  await new Promise(resolve => setTimeout(resolve, 300));
  const newId = Math.max(...directors.map(d => d.id)) + 1;
  const newDirector = { ...director, id: newId };
  directors.push(newDirector);
  return newDirector;
}

export const postActor = async (actor) => {
  await new Promise(resolve => setTimeout(resolve, 300));
  const newId = Math.max(...actors.map(a => a.id)) + 1;
  const newActor = { ...actor, id: newId };
  actors.push(newActor);
  return newActor;
}

export const getDirectors = async () => {
  await new Promise(resolve => setTimeout(resolve, 300));
  return directors;
}

export const getActors = async () => {
  await new Promise(resolve => setTimeout(resolve, 300));
  return actors;
}
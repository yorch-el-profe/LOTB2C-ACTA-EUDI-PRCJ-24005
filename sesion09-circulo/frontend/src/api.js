// Funciones simuladas asíncronas
export const getMovies = async () => {
  // Hace una petición de tipo GET a la URL
  const response = await fetch('http://localhost:8080/movies');

  // Convierte el binario en un JSON
  const movies = await response.json();

  return movies;
}

export const getMovie = async (id) => {
  const response = await fetch(`http://localhost:8080/movies/${id}`);
  const movie = await response.json();
  return movie;
}

export const postMovie = async (movie) => {
  const response = await fetch('http://localhost:8080/movies', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(movie) // Convierte el objeto en su forma JSON de string
  });

  return response.json();
}

export const getDirectors = async () => {
  const response = await fetch('http://localhost:8080/directors');
  return response.json();
}

export const getActors = async () => {
  const response = await fetch('http://localhost:8080/actors');
  return response.json();
}
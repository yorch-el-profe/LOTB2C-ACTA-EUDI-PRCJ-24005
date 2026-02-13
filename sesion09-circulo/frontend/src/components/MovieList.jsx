import React from 'react'

const MovieList = ({ movies, onMovieClick }) => {
  return (
    <div className="d-flex flex-wrap justify-content-center mt-4">
      {movies.map(movie => (
        <div key={movie.id} className="card m-2" style={{ width: '200px', cursor: 'pointer' }} onClick={() => onMovieClick(movie.id)}>
          <img src={movie.poster} className="card-img-top" alt={movie.title} />
          <div className="card-body">
            <h5 className="card-title">{movie.title}</h5>
          </div>
        </div>
      ))}
    </div>
  )
}

export default MovieList
import React from 'react'

const MovieModal = ({ show, movie, onClose }) => {
  if (!show || !movie) return null

  return (
    <>
      <div className="modal-backdrop show"></div>
      <div className={`modal fade ${show ? 'show' : ''}`} style={{ display: show ? 'block' : 'none' }} tabIndex="-1">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">{movie.title}</h5>
              <button type="button" className="btn-close" onClick={onClose}></button>
            </div>
            <div className="modal-body">
              <p><strong>Year:</strong> {movie.year}</p>
              <p><strong>Genre:</strong> {movie.genre}</p>
              <p><strong>Director:</strong> {movie.director.name}</p>
              <p><strong>Actors:</strong> {movie.actors.map(a => a.name).join(', ')}</p>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default MovieModal
import React, { useState, useEffect } from 'react'
import { getDirectors, getActors, postMovie } from '../api.js'

const AddMovieModal = ({ show, onClose, onAddMovie }) => {
  const [newMovie, setNewMovie] = useState({ title: '', year: '', genre: '', poster: '', directorId: '', actorIds: [] })
  const [newDirector, setNewDirector] = useState('')
  const [newActors, setNewActors] = useState([])
  const [directorsList, setDirectorsList] = useState([])
  const [actorsList, setActorsList] = useState([])

  useEffect(() => {
    if (show) {
      const loadLists = async () => {
        const dirs = await getDirectors()
        const acts = await getActors()
        setDirectorsList(dirs)
        setActorsList(acts)
      }
      loadLists()
    }
  }, [show])

  const handleSubmit = async () => {
    let director
    if (newDirector) {
      director = { name: newDirector }
    } else {
      director = directorsList.find(d => d.id == newMovie.directorId)
    }
    const actorObjects = newMovie.actorIds.map(id => actorsList.find(a => a.id == id))
    for (const actorName of newActors) {
      if (actorName) {
        actorObjects.push({ name: actorName })
      }
    }
    const movie = {
      title: newMovie.title,
      year: parseInt(newMovie.year),
      genre: newMovie.genre,
      poster: newMovie.poster,
      director,
      actors: actorObjects
    }
    await postMovie(movie)
    onAddMovie()
    onClose()
    setNewMovie({ title: '', year: '', genre: '', poster: '', directorId: '', actorIds: [] })
    setNewDirector('')
    setNewActors([])
  }

  if (!show) return null

  return (
    <>
      <div className="modal-backdrop show"></div>
      <div className={`modal fade ${show ? 'show' : ''}`} style={{ display: show ? 'block' : 'none' }} tabIndex="-1">
        <div className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <h5 className="modal-title">Add New Movie</h5>
              <button type="button" className="btn-close" onClick={onClose}></button>
            </div>
            <div className="modal-body">
              <form>
                <div className="mb-3">
                  <label className="form-label">Title</label>
                  <input type="text" className="form-control" value={newMovie.title} onChange={(e) => setNewMovie({ ...newMovie, title: e.target.value })} />
                </div>
                <div className="mb-3">
                  <label className="form-label">Year</label>
                  <input type="number" className="form-control" value={newMovie.year} onChange={(e) => setNewMovie({ ...newMovie, year: e.target.value })} />
                </div>
                <div className="mb-3">
                  <label className="form-label">Genre</label>
                  <input type="text" className="form-control" value={newMovie.genre} onChange={(e) => setNewMovie({ ...newMovie, genre: e.target.value })} />
                </div>
                <div className="mb-3">
                  <label className="form-label">Poster URL</label>
                  <input type="text" className="form-control" value={newMovie.poster} onChange={(e) => setNewMovie({ ...newMovie, poster: e.target.value })} />
                </div>
                <div className="mb-3">
                  <label className="form-label">Director</label>
                  <select className="form-select" value={newMovie.directorId} onChange={(e) => setNewMovie({ ...newMovie, directorId: e.target.value })}>
                    <option value="">Select Director</option>
                    {directorsList.map(d => <option key={d.id} value={d.id}>{d.name}</option>)}
                  </select>
                  <input type="text" className="form-control mt-2" placeholder="Or add new director" value={newDirector} onChange={(e) => setNewDirector(e.target.value)} />
                </div>
                <div className="mb-3">
                  <label className="form-label">Actors</label>
                  <select multiple className="form-select" value={newMovie.actorIds} onChange={(e) => setNewMovie({ ...newMovie, actorIds: Array.from(e.target.selectedOptions, option => option.value) })}>
                    {actorsList.map(a => <option key={a.id} value={a.id}>{a.name}</option>)}
                  </select>
                  <input type="text" className="form-control mt-2" placeholder="Add new actor" value={newActors[0] || ''} onChange={(e) => setNewActors([e.target.value])} />
                </div>
              </form>
            </div>
            <div className="modal-footer">
              <button type="button" className="btn btn-secondary" onClick={onClose}>Close</button>
              <button type="button" className="btn btn-primary" onClick={handleSubmit}>Add Movie</button>
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default AddMovieModal
import { useState, useEffect } from 'react'
import './App.css'
import { getMovies, getMovie } from './api.js'
import Navbar from './components/Navbar.jsx'
import MovieList from './components/MovieList.jsx'
import MovieModal from './components/MovieModal.jsx'
import AddMovieModal from './components/AddMovieModal.jsx'

function App() {
  const [movieList, setMovieList] = useState([])
  const [selectedMovie, setSelectedMovie] = useState(null)
  const [showDetailModal, setShowDetailModal] = useState(false)
  const [showAddModal, setShowAddModal] = useState(false)

  useEffect(() => {
    const fetchMovies = async () => {
      const movies = await getMovies()
      setMovieList(movies)
    }
    fetchMovies()
  }, [])

  const handleMovieClick = async (id) => {
    const movie = await getMovie(id)
    setSelectedMovie(movie)
    setShowDetailModal(true)
  }

  const handleAddMovie = async () => {
    const movies = await getMovies()
    setMovieList(movies)
  }

  const handleCloseDetailModal = () => {
    setShowDetailModal(false)
    setSelectedMovie(null)
  }

  return (
    <div className="container-fluid pt-4">
      <Navbar onAddMovieClick={() => setShowAddModal(true)} />
      <MovieList movies={movieList} onMovieClick={handleMovieClick} />
      <MovieModal show={showDetailModal} movie={selectedMovie} onClose={handleCloseDetailModal} />
      <AddMovieModal show={showAddModal} onClose={() => setShowAddModal(false)} onAddMovie={handleAddMovie} />
    </div>
  )
}

export default App

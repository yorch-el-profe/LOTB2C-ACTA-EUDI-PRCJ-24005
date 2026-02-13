import React from 'react'

const Navbar = ({ onAddMovieClick }) => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top px-3">
      <div className="container-fluid">
        <a className="navbar-brand" href="#" style={{color: 'red', fontWeight: 'bold'}}>Nesflis</a>
        <button className="btn btn-primary btn-sm" onClick={onAddMovieClick}>Add Movie</button>
      </div>
    </nav>
  )
}

export default Navbar
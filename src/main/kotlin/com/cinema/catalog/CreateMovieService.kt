package com.cinema.catalog

import com.cinema.model.Movie
import com.cinema.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateMovieService @Autowired constructor(val movieRepository: MovieRepository) {
    fun save(movie: Movie): Movie {
        return movieRepository.save(movie)
    }
}
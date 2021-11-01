package com.cinema.catalog

import com.cinema.model.Movie
import com.cinema.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchMovieService @Autowired constructor(val movieRepository: MovieRepository) {
    fun get(id: Long): Movie = movieRepository.findById(id).get()
}
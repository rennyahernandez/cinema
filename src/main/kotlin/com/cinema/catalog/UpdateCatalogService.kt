package com.cinema.catalog

import com.cinema.model.Movie
import com.cinema.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UpdateCatalogService @Autowired constructor(val movieRepository: MovieRepository) {
    fun update(): Movie {
        return TODO("NOT IMPLEMENTED YET")
    }
}
package com.cinema.repository

import com.cinema.model.Movie
import com.cinema.model.ShowTime
import org.springframework.data.repository.CrudRepository

interface ShowTimeRepository: CrudRepository<ShowTime, Long> {
    fun findAllByMovie(movie: Movie): Iterable<ShowTime>
    fun findAllByMovieId(movieId: Long): Iterable<ShowTime>

}
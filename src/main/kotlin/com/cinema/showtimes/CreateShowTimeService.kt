package com.cinema.showtimes

import com.cinema.model.ShowTime
import com.cinema.repository.MovieRepository
import com.cinema.repository.ShowTimeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateShowTimeService @Autowired constructor(val movieRepository: MovieRepository,
                                                   val showTimeRepository: ShowTimeRepository) {
    fun create(movieId: Long, showTime: ShowTime): ShowTime {
        val maybeMovie = movieRepository.findById(movieId)
        return when {
            maybeMovie.isPresent -> showTimeRepository.save(showTime.copy(movie = maybeMovie.get()))
            else -> throw IllegalArgumentException("Movie $movieId is not valid")
        }
    }
}
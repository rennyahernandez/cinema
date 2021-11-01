package com.cinema.showtimes

import com.cinema.model.ShowTime
import com.cinema.repository.ShowTimeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchShowTimeService @Autowired constructor(val showTimeRepository: ShowTimeRepository) {
    fun get(movieId: Long): Iterable<ShowTime> = showTimeRepository.findAllByMovieId(movieId)
}
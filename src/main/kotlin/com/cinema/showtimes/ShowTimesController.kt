package com.cinema.showtimes

import com.cinema.model.ShowTime
import com.cinema.repository.ShowTimeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.websocket.server.PathParam


@RestController
@RequestMapping("/cinema")
class ShowTimesController @Autowired constructor(val fetchShowTimeService: FetchShowTimeService) {

    @GetMapping("/movie/{movieId}/show-times/")
    fun getShowTimesByMovieId(@PathVariable movieId: Long): Iterable<ShowTime> {
        return fetchShowTimeService.get(movieId)
    }
}
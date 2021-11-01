package com.cinema.showtimes

import com.cinema.model.ShowTime
import com.cinema.repository.ShowTimeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam


@RestController
@RequestMapping("/cinema")
class ShowTimesController @Autowired constructor(
    val fetchShowTimeService: FetchShowTimeService,
    val createShowTimeService: CreateShowTimeService,
    val updateShowTimeService: UpdateShowTimeService
    ) {

    @GetMapping("/movie/{movieId}/show-times")
    fun getShowTimesByMovieId(@PathVariable movieId: Long): Iterable<ShowTime> {
        return fetchShowTimeService.get(movieId)
    }

    @PostMapping("/movie/{movieId}/show-time")
    fun createShowTimeByMovieId(@PathVariable movieId: Long, @RequestBody showTime: ShowTime): ShowTime {
        return createShowTimeService.create(movieId, showTime)
    }

    @PutMapping("/show-time")
    fun updateShowTimeByMovieId(@RequestBody showTime: ShowTime): ShowTime {
        return updateShowTimeService.update(showTime)
    }
}
package com.cinema

import com.cinema.model.Movie
import com.cinema.model.ShowTime
import java.math.BigDecimal
import java.time.LocalDateTime

class MovieObjectMother {
    val aMovie = Movie(
        1,
        "aName",
        "aDescription",
        "an Imdb Id",
        "2020-01-01",
        "Good",
        120,
        setOf(),
        BigDecimal.TEN
    )

    val aShowTime = ShowTime(
        1,
        aMovie,
        LocalDateTime.now(),
    )
}
package com.cinema

import com.cinema.catalog.clients.ImdbInfo
import com.cinema.model.Movie
import com.cinema.model.ShowTime
import java.math.BigDecimal
import java.time.LocalDateTime

class MovieObjectMother {
    val aMovie = Movie(
        1,
        "aName",
        "aDescription",
        "anImdbId",
        "2020-01-01",
        120,
        setOf(),
        BigDecimal.TEN,
        setOf(),
        ImdbInfo(
            title =   "The Fast and the Furious: Tokyo Drift",
            year = "2006",
            rated = "PG-13",
            released =  "16 Jun 2006",
            runtime =  "104 min",
            genre =  "Action, Crime, Thriller",
            director = "Justin Lin",
            writer = "Chris Morgan",
            actors =  "Lucas Black, Zachery Ty Bryan, Shad Moss",
            plot =  "A teenager becomes a major competitor in the world of drift racing after moving in with his father in Tokyo to avoid a jail sentence in America.",
            language = "English, Japanese, Portuguese",
            country =  "United States, Germany, Japan",
            awards =  "1 win & 4 nominations",
             poster = "https://m.media-amazon.com/images/M/MV5BMTQ2NTMxODEyNV5BMl5BanBnXkFtZTcwMDgxMjA0MQ@@._V1_SX300.jpg",
            ratings =  listOf(
                mapOf(
                    "Source" to "Internet Movie Database",
                    "Value" to "6.0/10"
                )
                ,
                mapOf(
                    "Source" to "Rotten Tomatoes",
                    "Value" to "38%"
                )
                ,
                mapOf(
                    "Source" to "Metacritic",
                    "Value" to "45/100"
                )
            ),
            metascore =  "45",
            imdbRating = "6.0",
            imdbId = "tt0463985",
            type = "movie",
            dvd = "26 Sep 2006",
            boxOffice =  "$62,514,415",
            production = "N/A",
            website =  "N/A",
            response =  "True"
        )
    )

    val aShowTime = ShowTime(
        1,
        aMovie,
        LocalDateTime.now(),
    )
}
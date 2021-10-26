package com.cinema.catalog

import com.cinema.model.Movie
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service

@Service
class FetchCatalogService {
    private val movies = setOf(
        Movie(1, "The Fast and the Furious", "tt0232500"),
        Movie(2, " 2 Fast 2 Furious", "tt0322259"),
        Movie(3, "The Fast and the Furious: Tokyo Drift", "tt0463985"),
        Movie(4,"Fast & Furious", "tt1013752" ),
        Movie(5, "Fast Five", "tt1596343"),
        Movie(6, "Fast & Furious 6", "tt1905041"),
        Movie(7, "Furious 7", "tt2820852"),
        Movie(8, "The Fate of the Furious", "tt4630562")
    )

    fun get() = movies

}
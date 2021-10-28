package com.cinema.catalog

import com.cinema.model.Movie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cinema/catalog")
class CatalogController constructor(
    val fetchCatalogService: FetchCatalogService,
    val updateCatalogService: UpdateCatalogService,
    val createMovieService: CreateMovieService
    ){

    @GetMapping("")
    fun getCatalog(): MutableIterable<Movie> {
        return fetchCatalogService.get()
    }

    @PostMapping("/movie")
    fun createMovie(@RequestBody movie: Movie): Movie {
        return createMovieService.save(movie)
    }
}



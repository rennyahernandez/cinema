package com.cinema.catalog

import com.cinema.model.Movie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/cinema")
class CatalogController constructor(
    val fetchCatalogService: FetchCatalogService,
    val updateCatalogService: UpdateCatalogService,
    val createMovieService: CreateMovieService,
    val fetchMovieService: FetchMovieService
    ){

    @GetMapping("catalog")
    fun getCatalog(): MutableIterable<Movie> {
        return fetchCatalogService.get()
    }

    @PostMapping("/movie")
    fun createMovie(@RequestBody movie: Movie): Movie {
        return createMovieService.save(movie)
    }

    @GetMapping("/movie/{movieId}")
    fun getMovie(@PathVariable movieId: Long): Movie {
        return fetchMovieService.get(movieId)
    }
}



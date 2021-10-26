package com.cinema.catalog

import com.cinema.model.Movie
import io.reactivex.rxjava3.core.Single
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/catalog")
class CatalogController constructor(val fetchCatalogService: FetchCatalogService){

    @GetMapping("/")
    fun getCatalog(): Single<Set<Movie>> {
        return Single.just(fetchCatalogService.get())
    }
}



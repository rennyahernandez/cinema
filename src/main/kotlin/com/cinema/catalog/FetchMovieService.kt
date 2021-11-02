package com.cinema.catalog

import com.cinema.catalog.clients.ImdbClient
import com.cinema.model.Movie
import com.cinema.repository.MovieRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchMovieService @Autowired constructor(
    val movieRepository: MovieRepository,
    val imdbClient: ImdbClient
    ) {
    fun get(id: Long): Movie = movieRepository
        .findById(id)
        .map {
            if(it.imdbId != null ) {
              imdbClient
                  .getImdbInfo(imdbId = it.imdbId)
                  .let  { info -> it.copy(imdbInfo = info) }
            } else  {
                it
            }
        }
        .orElseThrow { NotFoundException("Movie $id is not found") }

}
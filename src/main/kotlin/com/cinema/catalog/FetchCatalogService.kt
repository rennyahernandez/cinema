package com.cinema.catalog

import com.cinema.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchCatalogService constructor(@Autowired val movieRepository: MovieRepository) {


    fun get() = movieRepository.findAll()

}
package com.cinema.repository

import com.cinema.model.Movie
import org.springframework.data.repository.CrudRepository

interface MovieRepository: CrudRepository<Movie, Long>
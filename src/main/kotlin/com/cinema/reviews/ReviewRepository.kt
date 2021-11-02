package com.cinema.reviews

import com.cinema.reviews.model.Review
import org.springframework.data.repository.CrudRepository

interface ReviewRepository: CrudRepository<Review, Long>
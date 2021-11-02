package com.cinema.reviews

import com.cinema.reviews.model.Review
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FetchReviewService @Autowired constructor(val reviewRepository: ReviewRepository) {
    fun get(movieId: Long): Review {
        return reviewRepository
            .findById(movieId)
            .orElseThrow { NoSuchElementException("Review Not Found") }
    }
}
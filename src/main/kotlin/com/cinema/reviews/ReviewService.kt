package com.cinema.reviews

import com.cinema.model.Movie
import com.cinema.repository.MovieRepository
import com.cinema.reviews.model.Review
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ReviewService @Autowired constructor(
    val  movieRepository: MovieRepository,
    val  reviewRepository: ReviewRepository
    ) {

    fun doReview(movieId: Long, review: Review): Review {
       return movieRepository.findById(movieId)
           .map { reviewRepository.save(review.copy(movie = it)) }
           .orElseThrow {
               NoSuchElementException("Movie is not valid")
           }
    }
}
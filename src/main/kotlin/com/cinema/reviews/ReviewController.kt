package com.cinema.reviews

import com.cinema.reviews.model.Review
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cinema")
class ReviewController @Autowired constructor(
    val reviewService: ReviewService,
    val fetchReviewService: FetchReviewService
) {

    @PostMapping("/movie/{movieId}/review")
    fun createReview(@PathVariable movieId: Long, @RequestBody review: Review): Review {
        return reviewService.doReview(movieId, review)
    }

    @GetMapping("/review/{movieId}")
    fun getReview(@PathVariable movieId: Long): Review {
        return fetchReviewService.get(movieId)
    }
}
package com.cinema.reviews.model

import com.cinema.model.Movie
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
@Table(name = "movie_reviews")
data class Review(
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:  Long = 0,
    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    @JsonIgnore
    val movie: Movie? = null,
    @Min(1)
    @Max(5)
    val rating: Int,
    val comments: String
    )
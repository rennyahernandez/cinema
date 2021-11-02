package com.cinema.model

import com.cinema.catalog.clients.ImdbInfo
import com.cinema.reviews.model.Review
import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import kotlin.jvm.Transient

@Entity
@Table(name = "movies")
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String? = null,
    val imdbId: String? = null,
    val releaseDate: String? = null,
    val runtimeMinutes: Int? = null,
    @OneToMany(cascade= [], mappedBy="movie")
    @JsonIgnore
    val showTimes: Set<ShowTime> = setOf(),
    val price: BigDecimal? = null,
    @OneToMany(cascade= [], mappedBy="movie")
    @JsonIgnore
    val reviews: Set<Review>? = setOf(),
    @Transient
    val imdbInfo: ImdbInfo? = null
)
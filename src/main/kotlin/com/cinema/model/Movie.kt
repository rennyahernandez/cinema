package com.cinema.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Entity
@Table(name = "movies")
data class Movie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String? = null,
    val imdbId: String? = null,
    val releaseDate: String,
    val runtimeMinutes: Int,
    @OneToMany(cascade= [], mappedBy="movie")
    @JsonIgnore
    val showTimes: Set<ShowTime> = setOf(),
    val price: BigDecimal
)
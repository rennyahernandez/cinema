package com.cinema.model

import javax.persistence.*

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
    val rating: String,
    val runtimeMinutes: Int
)
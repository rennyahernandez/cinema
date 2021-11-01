package com.cinema.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "show_times")
data class ShowTime(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    @JsonIgnore
    val movie: Movie,
    @Column(name = "show_time")
    val showDateTime: LocalDateTime
)
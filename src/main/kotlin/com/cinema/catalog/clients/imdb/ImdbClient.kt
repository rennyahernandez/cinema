package com.cinema.catalog.clients

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ImdbClient @Autowired constructor(val restTemplate: RestTemplate, @Value("\${imdb.key}") val key: String) {
    fun getImdbInfo(imdbId: String): ImdbInfo? {
        return restTemplate.getForEntity("http://www.omdbapi.com/?apikey=$key&i=$imdbId", ImdbInfo::class.java)
            .body
    }
}

data class ImdbInfo(
        @JsonProperty("Title")
        val title: String,
        @JsonProperty("Year")
        val year: String,
        @JsonProperty("Rated")
        val rated: String,
        @JsonProperty("Released")
        val released: String,
        @JsonProperty("Runtime")
        val runtime: String,
        @JsonProperty("Genre")
        val genre: String,
        @JsonProperty("Director")
        val director: String,
        @JsonProperty("Writer")
        val writer: String,
        @JsonProperty("Actors")
        val actors: String,
        @JsonProperty("Plot")
        val plot: String,
        @JsonProperty("Language")
        val language: String,
        @JsonProperty("Country")
        val country: String,
        @JsonProperty("Awards")
        val awards: String,
        @JsonProperty("Poster")
        val poster: String,
        @JsonProperty("Ratings")
        val ratings: List<Map<String, String>>,
        @JsonProperty("Metascore")
        val metascore: String,
        @JsonProperty("imdbRating")
        val imdbRating: String,
        @JsonProperty("imdbID")
        val imdbId: String,
        @JsonProperty("Type")
        val type: String,
        @JsonProperty("DVD")
        val dvd: String,
        @JsonProperty("BoxOffice")
        val boxOffice: String,
        @JsonProperty("Production")
        val production: String,
        @JsonProperty("Website")
        val website: String,
        @JsonProperty("Response")
        val response: String
        )


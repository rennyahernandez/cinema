package com.cinema.catalog

import com.cinema.model.Movie
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.jayway.jsonpath.TypeRef
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UpdateMovieTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `given a movie when creating it must return 2xx`() {
        val request = mapOf("name" to "Matrix", "imdb_id" to "xx")

        val result = testRestTemplate.postForEntity<Movie>("/cinema/catalog/movie", request)

        Assertions.assertNotNull(result.body!!.id)
        Assertions.assertEquals(request["name"], result.body!!.name)
        Assertions.assertEquals(request["imdb_id"], result.body!!.imdbId)

    }
}
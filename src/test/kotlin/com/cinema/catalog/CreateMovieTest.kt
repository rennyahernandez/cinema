package com.cinema.catalog

import com.cinema.model.Movie
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.math.BigDecimal

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateMovieTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `given a movie when creating it must return 2xx`() {
        val request = mapOf(
            "name" to "Matrix",
            "description" to "Best Movie Ever",
            "release_date" to "1999-06-01",
            "imdb_id" to "xx",
            "price" to BigDecimal.valueOf(10)
        )

        val result = testRestTemplate.postForEntity<Movie>("/cinema/movie", request)

        Assertions.assertNotNull(result.body!!.id)
        Assertions.assertEquals(request["name"], result.body!!.name)
        Assertions.assertEquals(request["imdb_id"], result.body!!.imdbId)
        Assertions.assertEquals(request["release_date"], result.body!!.releaseDate)
        Assertions.assertEquals(request["description"], result.body!!.description)
        Assertions.assertEquals(request["price"], result.body!!.price)
    }
}
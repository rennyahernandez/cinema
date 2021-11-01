package com.cinema.catalog

import com.cinema.model.Movie
import com.cinema.model.ShowTime
import com.cinema.repository.MovieRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetMovieTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @MockBean
    lateinit var movieRepository: MovieRepository

    @Test
    fun `given a catalog request when responding must return 2xx and a not empty set`() {
        val result = testRestTemplate.getForEntity("/cinema/catalog", Set::class.java)

        Assertions.assertTrue(result.statusCode.is2xxSuccessful)
        Assertions.assertNotNull(result.body!!.isNotEmpty())
    }

    @Test
    fun `given an existing movie when fetching existing movie when checking price must be as expected`() {

        val expected = Movie(
                1,
                "aName",
                "aDescription",
                "an Imdb Id",
                "2020-01-01",
                "Good",
                120,
                setOf(),
                BigDecimal.TEN
            )

        `when`(movieRepository.findById(1)).thenReturn(Optional.of(expected))
        val result =  testRestTemplate.getForEntity("/cinema/movie/1", Movie::class.java)


        Assertions.assertNotNull(result.body)
        Assertions.assertEquals(expected.price, result.body?.price!!)
    }
}
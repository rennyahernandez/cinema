package com.cinema.catalog

import com.cinema.MovieObjectMother
import com.cinema.model.Movie
import com.cinema.repository.MovieRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension
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

        val expected = MovieObjectMother().aMovie

        `when`(movieRepository.findById(1)).thenReturn(Optional.of(expected))
        val result =  testRestTemplate.getForEntity("/cinema/movie/1", Movie::class.java)


        Assertions.assertNotNull(result.body)
        Assertions.assertEquals(expected.price, result.body?.price!!)
    }
}
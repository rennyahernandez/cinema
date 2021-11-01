package com.cinema.showtimes

import com.cinema.MovieObjectMother
import com.cinema.model.ShowTime
import com.cinema.repository.MovieRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateShowTimeTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @MockBean
    lateinit var movieRepository: MovieRepository


    @Test
    fun `given an existing movie when creating valid showtime must be ok`(){
        val movieObjectMother = MovieObjectMother()

        val aMovie = movieObjectMother.aMovie
        val expectedShowTime: Map<String, Any> = mapOf("show_date_time" to LocalDateTime.now())

        `when`(movieRepository.findById(1)).thenReturn(Optional.of(aMovie))


        val request = testRestTemplate.postForEntity("/cinema/movie/1/show-time/", expectedShowTime, ShowTime::class.java)

        assertNotNull(request.body)
        assertNotNull(request.body?.id)
        assertNotNull(request.body?.showDateTime)
        assertEquals(expectedShowTime["show_date_time"], request.body?.showDateTime)
    }
}
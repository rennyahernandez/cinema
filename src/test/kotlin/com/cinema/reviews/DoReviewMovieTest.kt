package com.cinema.reviews

import com.cinema.MovieObjectMother
import com.cinema.model.Movie
import com.cinema.repository.MovieRepository
import com.cinema.reviews.model.Review
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpRequest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DoReviewMovieTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @MockBean
    lateinit var movieRepository: MovieRepository

    @Test
    fun `given an existing when creating a valid must go ok`(){
       `when`(movieRepository.findById(1)).thenReturn(Optional.of(MovieObjectMother().aMovie))
        val aReview = Review(rating = 1, comments = "this is a comment..")

        val response = testRestTemplate.postForEntity("/cinema/movie/1/review/", HttpEntity(aReview), Review::class.java)

        Assertions.assertNotNull(response)
    }
}
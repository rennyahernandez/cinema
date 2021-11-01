package com.cinema.showtimes

import com.cinema.MovieObjectMother
import com.cinema.model.ShowTime
import com.cinema.repository.ShowTimeRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UpdateShowTimeTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Autowired
    lateinit var repository: ShowTimeRepository

    @Test
    fun `given an existing show time when updating must return updated instance`(){

        val oldShowTime = repository.save(MovieObjectMother().aShowTime)

        val request = mapOf("id" to oldShowTime.id, "show_date_time" to LocalDateTime.now())

        val response = testRestTemplate.exchange("/cinema/show-time", HttpMethod.PUT, HttpEntity(request), ShowTime::class.java)

        Assertions.assertNotNull(response.body)
        Assertions.assertEquals(oldShowTime.id, response.body?.id)
        Assertions.assertEquals(request["show_date_time"], response.body?.showDateTime)
    }

    @Test
    fun `given a non existing show time when updating must return error`(){


        val request = mapOf("id" to Long.MAX_VALUE, "show_date_time" to LocalDateTime.now())

        val response = testRestTemplate.exchange("/cinema/show-time", HttpMethod.PUT, HttpEntity(request), Map::class.java)

        Assertions.assertNotNull(response.body)
        Assertions.assertTrue(response.statusCode.is5xxServerError)
    }
}
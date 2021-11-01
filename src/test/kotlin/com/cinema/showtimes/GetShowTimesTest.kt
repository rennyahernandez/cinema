package com.cinema.showtimes

import com.cinema.MovieObjectMother
import com.cinema.model.Movie
import com.cinema.model.ShowTime
import com.cinema.repository.ShowTimeRepository
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetShowTimesTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @MockBean
    lateinit var showTimeService: FetchShowTimeService

    @Test
    fun `given an existing movie when fetching existing show time must go ok`() {

        val expectedShowTime = MovieObjectMother().aShowTime

        `when`(showTimeService.get(1))
            .thenReturn(
                setOf(
                    expectedShowTime
                )
            )

       val result =  testRestTemplate.getForEntity("/cinema/movie/1/show-times/", Iterable::class.java)

        val body = result.body?.first() as HashMap<*, *>

        Assertions.assertNotNull(body)
        Assertions.assertEquals(expectedShowTime.id, (body["id"] as Int).toLong())
        Assertions.assertEquals(expectedShowTime.showDateTime.format(DateTimeFormatter.ISO_DATE_TIME), body["show_date_time"])
    }
}
package com.cinema.showtimes

import com.cinema.model.Movie
import com.cinema.model.ShowTime
import com.cinema.repository.ShowTimeRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetShowTimesTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @MockBean
    lateinit var showTimeService: FetchShowTimeService

    @Test
    fun `given an existing movie when fetching existing show time must go ok`() {

        val expectedShowTime = ShowTime(
            1,
            Movie(
                1,
                "aName",
                "aDescription",
                "an Imdb Id",
                "2020-01-01",
                "Good",
                120,
                setOf()
            ),
            LocalDateTime.now()
        )

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
        Assertions.assertEquals(expectedShowTime.showDateTime.toString(), body["show_date_time"])
    }
}
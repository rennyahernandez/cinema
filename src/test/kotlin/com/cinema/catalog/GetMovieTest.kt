package com.cinema.catalog

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GetMovieTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `given a catalog request when responding must return 2xx and a not empty set`() {
        val result = testRestTemplate.getForEntity("/cinema/catalog", Set::class.java)

        Assertions.assertTrue(result.statusCode.is2xxSuccessful)
        Assertions.assertNotNull(result.body!!.isNotEmpty())
    }
}
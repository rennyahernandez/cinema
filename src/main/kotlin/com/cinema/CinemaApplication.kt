package com.cinema

import com.fasterxml.jackson.datatype.jsr310.JSR310Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@SpringBootApplication
class CinemaApplication

fun main(args: Array<String>) {
    jsonMapper {
        addModule(kotlinModule())
    }

    runApplication<CinemaApplication>(*args)
}

@Configuration
class FlywayMigration {
    @Bean
    fun cleanMigrateStrategy(): FlywayMigrationStrategy {
        return FlywayMigrationStrategy { flyway: Flyway ->
            flyway.repair()
            flyway.migrate()
        }
    }
}

@Configuration
class RestTemplateConfiguration {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

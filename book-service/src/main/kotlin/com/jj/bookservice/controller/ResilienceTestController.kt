package com.jj.bookservice.controller

import io.github.resilience4j.retry.annotation.Retry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("book-service")
class ResilienceTestController {

    private val logger: Logger = LoggerFactory.getLogger(ResilienceTestController::class.java)

    @GetMapping("resilience")
    @Retry(name = "resilience")
    fun resilience(): String? {
        logger.info("Request to resilience is received!")
        val response = RestTemplate()
            .getForEntity("http://localhost:8080/test", String::class.java)
        return response.body
    }
}
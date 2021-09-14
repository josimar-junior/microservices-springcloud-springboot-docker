package com.jj.bookservice.controller

import com.jj.bookservice.model.Book
import com.jj.bookservice.proxy.CambioProxy
import com.jj.bookservice.service.BookService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.core.env.Environment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("book-service")
@Tag(name = "Book endpoint")
class BookController(val environment: Environment,
                     val service: BookService,
                     val proxy: CambioProxy) {

    @GetMapping("/{id}/{currency}")
    @Operation(summary = "Find book by id")
    fun findBook(@PathVariable id: Long, @PathVariable currency: String): ResponseEntity<Book> {

        val book = service.findById(id)

        val port = environment.getProperty("local.server.port")

        val cambio = proxy.getCambio(book.price, "USD", currency)

        book.environment = port
        book.price = cambio.convertedValue
        return ResponseEntity.ok(book)
    }
}
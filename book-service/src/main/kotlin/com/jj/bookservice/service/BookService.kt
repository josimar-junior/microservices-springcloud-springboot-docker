package com.jj.bookservice.service

import com.jj.bookservice.model.Book
import com.jj.bookservice.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun findById(id: Long): Book = repository.findById(id).orElseThrow{RuntimeException("Book not found")}
}
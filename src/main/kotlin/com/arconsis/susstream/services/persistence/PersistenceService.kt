package com.arconsis.susstream.services.persistence

import com.arconsis.susstream.services.models.Book
import jakarta.enterprise.context.ApplicationScoped
import java.util.*
import java.util.logging.Logger

@ApplicationScoped
class PersistenceService() {
    private val logger = Logger.getLogger(PersistenceService::class.java.name)

    fun getAllBooks(): List<Book> {
        return emptyList()
    }

    fun createBook(title: String, authors: List<UUID>): Book {
        TODO("Not yet implemented")
    }

    fun getBookById(id: UUID): Book? {
        return null
    }

    fun deleteBookById(bookId: UUID) {
    }
}

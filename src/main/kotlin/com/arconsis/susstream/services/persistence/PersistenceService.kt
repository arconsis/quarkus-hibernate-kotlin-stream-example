package com.arconsis.susstream.services.persistence

import com.arconsis.susstream.services.models.Book
import com.arconsis.susstream.services.persistence.entities.AuthorEntity
import com.arconsis.susstream.services.persistence.entities.BookEntity
import jakarta.enterprise.context.ApplicationScoped
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import jakarta.ws.rs.NotFoundException
import java.util.*
import java.util.logging.Level
import java.util.logging.Logger

@ApplicationScoped
class PersistenceService(private val entityManager: EntityManager) {
    private val logger = Logger.getLogger(PersistenceService::class.java.name)

    fun getAllBooks(): List<Book> {
        return entityManager.createNamedQuery(BookEntity.FIND_ALL_BOOKS, BookEntity::class.java)
            .resultList
            .toModels()
    }

    @Transactional
    fun createBook(title: String, authors: List<UUID>): Book {
        try {
            val authorReferences = authors.map { entityManager.getReference(AuthorEntity::class.java, it) }
            val newBook = BookEntity(title = title, authors = authorReferences.toMutableSet())

            entityManager.persist(newBook)

            return newBook.toModel()

        }catch(e: EntityNotFoundException){
            logger.log(Level.WARNING, e) { "Author does not exist" }
            throw NotFoundException()
        }
    }

    fun getBookById(id: UUID): Book? {
        return entityManager.find(BookEntity::class.java, id)
            ?.toModel()
    }

    @Transactional
    fun deleteBookById(bookId: UUID) {
        try {
            val bookReference = entityManager.getReference(BookEntity::class.java, bookId)
            entityManager.remove(bookReference)
        } catch (e: EntityNotFoundException) {
            // ignore, all good if already deleted
        }
    }
}



package com.arconsis.susstream.rest

import com.arconsis.susstream.rest.dto.BookDto
import com.arconsis.susstream.rest.dto.BooksDto
import com.arconsis.susstream.rest.dto.CreateBookDto
import com.arconsis.susstream.services.persistence.PersistenceService
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import java.util.*

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class BooksResource(private val persistenceService: PersistenceService) {

    @GET
    fun getBooks(): BooksDto {
        val books = persistenceService.getAllBooks().toDtos()
        return BooksDto(books)
    }

    @POST
    fun createBook(createBookDto: CreateBookDto): BookDto {
        return persistenceService.createBook(createBookDto.title, createBookDto.authors).toDto()
    }

    @GET
    @Path("/{bookId}")
    fun getBookById(bookId: UUID): BookDto {
        return persistenceService.getBookById(bookId)?.toDto() ?: throw NotFoundException("Book with id $bookId not found")
    }

    @DELETE
    @Path("/{bookId}")
    fun deleteBookById(bookId: UUID) {
        persistenceService.deleteBookById(bookId)
    }
}


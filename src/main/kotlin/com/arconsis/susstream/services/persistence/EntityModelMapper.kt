package com.arconsis.susstream.services.persistence

import com.arconsis.susstream.services.models.Author
import com.arconsis.susstream.services.models.Book
import com.arconsis.susstream.services.persistence.entities.AuthorEntity
import com.arconsis.susstream.services.persistence.entities.BookEntity

fun List<BookEntity>.toModels(): List<Book> = map { it.toModel() }

fun BookEntity.toModel(): Book = Book(requireNotNull(id), title, authors.toModels())


fun Collection<AuthorEntity>.toModels(): List<Author> = map { it.toModel() }

fun AuthorEntity.toModel(): Author = Author(requireNotNull(id), name, birthdate)
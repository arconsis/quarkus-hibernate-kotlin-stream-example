package com.arconsis.susstream.rest

import com.arconsis.susstream.rest.dto.AuthorDto
import com.arconsis.susstream.rest.dto.BookDto
import com.arconsis.susstream.services.models.Author
import com.arconsis.susstream.services.models.Book

@JvmName("booksToDtos")
fun Collection<Book>.toDtos(): List<BookDto> = map { it.toDto() }

fun Book.toDto(): BookDto = BookDto(id, title, authors.toDtos())

@JvmName("authorsToDtos")
fun Collection<Author>.toDtos(): List<AuthorDto> = map { it.toDto() }

fun Author.toDto(): AuthorDto = AuthorDto(id, name, birthdate)
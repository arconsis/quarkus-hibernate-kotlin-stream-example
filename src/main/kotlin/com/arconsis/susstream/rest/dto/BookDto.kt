package com.arconsis.susstream.rest.dto

import java.util.UUID

data class BookDto (
    val id: UUID,
    val title: String,
    val authors: List<AuthorDto>
)
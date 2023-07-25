package com.arconsis.susstream.rest.dto

import java.time.LocalDate
import java.util.UUID

data class AuthorDto(
    val id: UUID,
    val name: String,
    val birthdate: LocalDate?
)
